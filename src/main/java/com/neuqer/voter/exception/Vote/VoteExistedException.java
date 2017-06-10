package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class VoteExistedException extends BaseException{
    public VoteExistedException() {
        super.setCode(30001);
        super.setMessage("The Vote Has Already Existed ");
    }
}
