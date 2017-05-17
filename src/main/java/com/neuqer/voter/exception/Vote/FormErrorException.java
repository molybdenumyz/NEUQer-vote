package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class FormErrorException extends BaseException {
    public FormErrorException(String message){setCode(30009);setMessage(message);}
}
