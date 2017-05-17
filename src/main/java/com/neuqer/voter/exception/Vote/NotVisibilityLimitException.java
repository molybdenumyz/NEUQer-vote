package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/22.
 */
public class NotVisibilityLimitException extends BaseException{
    public NotVisibilityLimitException() {
        super.setCode(30006);
        super.setMessage("Your vote is not visibility limit, Please check it");
    }
}
