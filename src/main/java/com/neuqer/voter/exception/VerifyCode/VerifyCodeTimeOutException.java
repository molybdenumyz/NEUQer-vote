package com.neuqer.voter.exception.VerifyCode;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/9.
 */
public class VerifyCodeTimeOutException extends BaseException {
    public VerifyCodeTimeOutException(){super.setCode(90002);super.setMessage("验证码超时");}
}
