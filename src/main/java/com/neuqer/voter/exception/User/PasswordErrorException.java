package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Lim on 17/3/16.
 */
public class PasswordErrorException extends BaseException {
    public PasswordErrorException(){
        super.setCode(10001);
    }
}
