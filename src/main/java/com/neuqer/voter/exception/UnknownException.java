package com.neuqer.voter.exception;

/**
 * Created by yinzhe on 17/5/17.
 */
public class UnknownException extends BaseException {
    public UnknownException() {
        super.setCode(10000);
    }

    public UnknownException(String messgae) {
        super.setCode(10001);
        super.setMessage(messgae);
    }
}
