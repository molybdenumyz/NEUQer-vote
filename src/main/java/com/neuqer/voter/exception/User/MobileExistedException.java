package com.neuqer.voter.exception.User;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by lumin on 17/3/16.
 */
public class MobileExistedException extends BaseException {
    public MobileExistedException(){
        super.setCode(10003);super.setMessage("手机号已存在");
    }
}
