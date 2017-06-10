package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class PasswordErrorException extends BaseException {
    public PasswordErrorException(){
        super.setCode(10001);
    }
}
