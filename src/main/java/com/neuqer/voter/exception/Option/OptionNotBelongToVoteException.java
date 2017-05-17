package com.neuqer.voter.exception.Option;

import com.neuqer.voter.exception.BaseException;

/**
 * Created by yinzhe on 17/5/12.
 */
public class OptionNotBelongToVoteException extends BaseException{
    public OptionNotBelongToVoteException(){super.setCode(50002);super.setMessage("修改的选项不属于该投票");}
}
