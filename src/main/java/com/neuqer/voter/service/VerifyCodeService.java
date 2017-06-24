package com.neuqer.voter.service;

import com.neuqer.voter.domain.VerifyCode;
import com.neuqer.voter.exception.User.UserExistedException;
import com.neuqer.voter.exception.User.UserNotExistException;
import com.neuqer.voter.exception.VerifyCode.IllegalVerfyCodeException;
import com.neuqer.voter.exception.VerifyCode.VerifyCodeTimeOutException;

/**
 * Created by yinzhe on 17/5/9.
 */

public interface VerifyCodeService {
    String sendVerifyCode(String mobile,int type) throws Exception;

    boolean checkVerifyCode(String mobile,int type,String code) throws IllegalVerfyCodeException, VerifyCodeTimeOutException;

    boolean updateVerifyCode(VerifyCode verifyCode,VerifyCode checkVerifyCode);
}
