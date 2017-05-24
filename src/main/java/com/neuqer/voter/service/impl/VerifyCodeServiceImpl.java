package com.neuqer.voter.service.impl;

import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.User;
import com.neuqer.voter.domain.VerifyCode;
import com.neuqer.voter.exception.BaseException;
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
    public boolean sendVerifyCode(String mobile,int type) throws UserNotExistException, UserExistedException {
        //String code  = Utils.createVerifyCode(); 假装在发送验证码
        String code = "1234";
        User user = userService.getUserByMobile(mobile);

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

        return updateVerifyCode(mobile,type,code);
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
    public boolean updateVerifyCode(String mobile, int type, String code) {
        VerifyCode checkVerifyCode = new VerifyCode(mobile, type, code);
        VerifyCode verifyCode = verifyCodeMapper.getVerifyCode(checkVerifyCode);
      boolean flag = false;
        if (verifyCode == null) {

            checkVerifyCode.setExpireAt(Utils.createTimeStamp()+300000);
            flag = verifyCodeMapper.addVerifyCode(checkVerifyCode);
        } else {
            //verifyCode.setCode(code);
            verifyCode.setExpireAt(Utils.createTimeStamp()+300000);
            flag = verifyCodeMapper.updateVerifyCode(verifyCode);
        }
        return flag;
    }
}
