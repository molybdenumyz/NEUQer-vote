package com.neuqer.voter.exception;

/**
 * Created by lumin on 17/3/16.
 */
public class UnknownException extends BaseException {
    public UnknownException() {
        super.setCode(10000);
    }

    public UnknownException(String messgae) {
        super.setCode(10000);
        super.setMessage(messgae);
    }
}
