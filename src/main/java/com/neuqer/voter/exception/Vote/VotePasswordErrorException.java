package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/21.
 */
public class VotePasswordErrorException extends BaseException{
    public VotePasswordErrorException() {
        super.setCode(30003);
        super.setMessage("Password Error");
    }
}
