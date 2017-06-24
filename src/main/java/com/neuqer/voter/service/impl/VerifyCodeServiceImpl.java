package com.neuqer.voter.service.impl;

import com.neuqer.voter.common.SmsSender;
import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.VerifyCode;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.User.UserExistedException;
import com.neuqer.voter.exception.User.UserNotExistException;
import com.neuqer.voter.exception.VerifyCode.IllegalVerfyCodeException;
import com.neuqer.voter.exception.VerifyCode.VerifyCodeTimeOutException;
import com.neuqer.voter.mapper.VerifyCodeMapper;
import com.neuqer.voter.service.UserService;
import com.neuqer.voter.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yinzhe on 17/5/9.
 */
@Service("VerifyCodeService")
public class VerifyCodeServiceImpl implements VerifyCodeService{
    @Autowired
    private VerifyCodeMapper verifyCodeMapper;

    @Autowired
    private UserService userService;



    /**
     *
     * @param mobile
     * @param type 1 注册
     * @return
     * @throws BaseException
     */
    @Override
    public String sendVerifyCode(String mobile,int type) throws Exception {
        String code  = Utils.createVerifyCode();

        User user = userService.getUserByMobile(mobile);
        SmsSender smsSender = new SmsSender();
        if(type == 1) {

            if (user != null) {
                if (user.getStatus() != 0)
                throw new UserExistedException();
            }
        }
        if(type == 2 || type == 3)//修改用户密码,忘记密码
        {
            if (user == null)
                throw new UserNotExistException();
        }

        VerifyCode checkVerifyCode = new VerifyCode(mobile, type);

        VerifyCode verifyCode = verifyCodeMapper.getVerifyCode(checkVerifyCode);

//        if (verifyCode != null){
//            long now = Utils.createTimeStamp();
//            if ((now -40000)< verifyCode.getUpdateAt())
//                throw new UnknownException("验证码两次时间间隔过短");
//            if (verifyCode.getNum() > 5){
//                if (verifyCode.getUpdateAt() + 86400000 > now)
//                    throw new UnknownException("一天请求次数有限");
//            }
//        }

        checkVerifyCode.setCode(code);
       // String result = smsSender.Sender(mobile,code);

       // System.out.println(result);

       // if (!(result.indexOf(",0")>=0)){
      //      throw new UnknownException("Can't send message");
      //  }
        if (!(updateVerifyCode(verifyCode,checkVerifyCode))){
            throw new UnknownException("Can't send message");
        }

        return code;
     }

    @Override
    public boolean checkVerifyCode(String mobile, int type,String code) throws IllegalVerfyCodeException, VerifyCodeTimeOutException {
        VerifyCode checkVerifyCode = new VerifyCode(mobile,type,code);

        VerifyCode verifyCode = verifyCodeMapper.getVerifyCode(checkVerifyCode);
        if (verifyCode == null)
            throw new IllegalVerfyCodeException();

        if (!verifyCode.getCode().equals(code))
            throw new IllegalVerfyCodeException();

        if (verifyCode.getExpireAt() < Utils.createTimeStamp())
            throw new VerifyCodeTimeOutException();

        return true;
    }

    @Override
    public boolean updateVerifyCode(VerifyCode verifyCode,VerifyCode checkVerifyCode) {
        long now = Utils.createTimeStamp();
      boolean flag = false;
        if (verifyCode == null) {
            checkVerifyCode.setUpdateAt(now);
            checkVerifyCode.setExpireAt(now+300000);
            checkVerifyCode.setNum(1);
            System.out.println(checkVerifyCode);
            flag = verifyCodeMapper.addVerifyCode(checkVerifyCode);
        } else {
            verifyCode.setCode(checkVerifyCode.getCode());
            verifyCode.setUpdateAt(now);
            verifyCode.setExpireAt(now+300000);
            Integer nowNum = verifyCode.getNum();

            if (now - verifyCode.getUpdateAt() < 86400000)
            {
                verifyCode.setNum(nowNum+1);
                flag = verifyCodeMapper.updateVerifyCode(verifyCode);
            }

            else {
                verifyCode.setNum(1);
                verifyCode.setUpdateAt(now);
                flag = verifyCodeMapper.updateVerifyCode(verifyCode);
            }
        }
        return flag;
    }
}
