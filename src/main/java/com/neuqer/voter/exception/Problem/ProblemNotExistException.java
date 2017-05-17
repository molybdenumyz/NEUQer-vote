package com.neuqer.voter.exception.Problem;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by Hotown on 17/3/19.
 */
public class ProblemNotExistException extends BaseException{
    public ProblemNotExistException() {
        super.setCode(40001);
    }
}
