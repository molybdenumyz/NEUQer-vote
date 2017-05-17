package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/22.
 */
public class TimeErrorException extends BaseException {
    public TimeErrorException(String message) {
        super.setCode(30005);
        super.setMessage(message);
    }
}
