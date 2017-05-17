package com.neuqer.voter.exception.VerifyCode;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/9.
 */
public class IllegalTypeException extends BaseException {
    public IllegalTypeException(){super.setCode(90003);super.setMessage("验证码类型错误");}
}
