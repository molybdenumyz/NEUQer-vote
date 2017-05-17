package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/19.
 */
public class VoteExistedException extends BaseException{
    public VoteExistedException() {
        super.setCode(30001);
        super.setMessage("The Vote Has Already Existed ");
    }
}
