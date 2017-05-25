package com.neuqer.voter.exception;

/**
 * Created by lumin on 17/3/16.
 */

public abstract class BaseException extends RuntimeException{
    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
