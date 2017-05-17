package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by lumin on 17/3/16.
 */
public class UserNotExistException extends BaseException {
    public UserNotExistException(){
        super.setCode(10002);
    }
}
