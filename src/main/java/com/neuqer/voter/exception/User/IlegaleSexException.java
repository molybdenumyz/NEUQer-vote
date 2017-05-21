package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/22.
 */
public class IlegaleSexException extends BaseException {
    public  IlegaleSexException(){super.setCode(10005); super.setMessage("sex input Error");}
}
