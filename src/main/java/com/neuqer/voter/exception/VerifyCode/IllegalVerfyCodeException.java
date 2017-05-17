package com.neuqer.voter.exception.VerifyCode;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/9.
 */
public class IllegalVerfyCodeException extends BaseException{

    public IllegalVerfyCodeException(){super.setCode(90001);super.setMessage("验证码错误");}
}
