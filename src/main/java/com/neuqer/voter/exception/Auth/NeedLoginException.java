package com.neuqer.voter.exception.Auth;

import com.neuqer.voter.exception.BaseException;

import java.util.UUID;

/**
 * Created by yinzhe on 17/5/17.
 */
public class NeedLoginException extends BaseException{
    public NeedLoginException(){
        super.setCode(20001);
    }
}
