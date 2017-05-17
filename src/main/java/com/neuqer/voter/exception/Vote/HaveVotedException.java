package com.neuqer.voter.exception.Vote;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/17.
 */
public class HaveVotedException extends BaseException{
    public HaveVotedException(){setCode(30007);setMessage("you have been voted");}
}
