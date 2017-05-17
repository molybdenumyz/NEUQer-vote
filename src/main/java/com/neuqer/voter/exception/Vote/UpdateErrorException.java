package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/28.
 */
public class UpdateErrorException extends BaseException {
    public UpdateErrorException(String message) {
        super.setCode(30008);
        super.setMessage(message);
    }
}
