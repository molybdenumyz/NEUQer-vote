package com.neuqer.voter.exception.Option;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class OptionNotExistException extends BaseException{
    public OptionNotExistException() {
        super.setCode(50001);
    }
}
