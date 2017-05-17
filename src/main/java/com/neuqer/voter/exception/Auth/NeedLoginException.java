package com.neuqer.voter.exception.Auth;

import com.neuqer.voter.exception.BaseException;

import java.util.UUID;

/**
 * Created by lumin on 17/3/17.
 */
public class NeedLoginException extends BaseException{
    public NeedLoginException(){
        super.setCode(20001);
    }
}
