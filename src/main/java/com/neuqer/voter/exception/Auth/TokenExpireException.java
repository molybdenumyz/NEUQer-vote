package com.neuqer.voter.exception.Auth;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class TokenExpireException extends BaseException {
    public TokenExpireException(){
        super.setCode(20002);
    }
}
