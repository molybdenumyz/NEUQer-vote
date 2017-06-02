package com.neuqer.voter.exception.Auth;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/10.
 */
public class NoPermissonException extends BaseException {
    public NoPermissonException(){super.setCode(20003);super.setMessage("没有相应权限执行此操作");}
}
