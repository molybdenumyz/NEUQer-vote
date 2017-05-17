package com.neuqer.voter.exception.Auth;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by lumin on 17/3/17.
 */
public class TokenExpireException extends BaseException {
    public TokenExpireException(){
        super.setCode(20002);
    }
}
