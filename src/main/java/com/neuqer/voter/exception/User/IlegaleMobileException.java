package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/4/19.
 */
public class IlegaleMobileException extends BaseException{
    public IlegaleMobileException() {
        super.setCode(10004);
    }
}
