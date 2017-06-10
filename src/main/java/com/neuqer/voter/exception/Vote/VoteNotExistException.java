package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class VoteNotExistException extends BaseException {
    public VoteNotExistException() {
        super.setCode(30002);
        super.setMessage("The vote is not exist or permission denied");
    }
}
