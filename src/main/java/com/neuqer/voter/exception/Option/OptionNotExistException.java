package com.neuqer.voter.exception.Option;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/25.
 */
public class OptionNotExistException extends BaseException{
    public OptionNotExistException() {
        super.setCode(50001);
    }
}
