package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class IlegaleMobileException extends BaseException{
    public IlegaleMobileException() {
        super.setCode(10004);
    }
}
