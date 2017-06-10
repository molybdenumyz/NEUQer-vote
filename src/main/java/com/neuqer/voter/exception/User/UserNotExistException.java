package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;


/**
 * Created by Hotown on 17/3/22.
 */
public class UserNotExistException extends BaseException {
    public UserNotExistException(){
        super.setCode(10002);
    }
}
