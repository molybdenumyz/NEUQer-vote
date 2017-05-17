package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/9.
 */
public class UserExistedException extends BaseException{
    public UserExistedException(){super.setCode(10005);}
}
