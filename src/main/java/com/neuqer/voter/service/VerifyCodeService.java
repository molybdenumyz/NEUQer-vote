package com.neuqer.voter.service;

import com.neuqer.voter.exception.User.UserExistedException;
import com.neuqer.voter.exception.User.UserNotExistException;
import com.neuqer.voter.exception.VerifyCode.IllegalVerfyCodeException;
import com.neuqer.voter.exception.VerifyCode.VerifyCodeTimeOutException;

/**
 * Created by yinzhe on 17/5/9.
 */

public interface VerifyCodeService {
    boolean sendVerifyCode(String mobile,int type) throws UserNotExistException, UserExistedException;
    boolean checkVerifyCode(String mobile,int type,String code) throws IllegalVerfyCodeException, VerifyCodeTimeOutException;

    boolean updateVerifyCode(String mobile,int type,String code);
}
