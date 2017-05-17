package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/19.
 */
public class VoteNotExistException extends BaseException {
    public VoteNotExistException() {
        super.setCode(30002);
        super.setMessage("The vote is not exist or permission denied");
    }
}
