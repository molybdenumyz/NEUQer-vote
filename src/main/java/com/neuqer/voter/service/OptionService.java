package com.neuqer.voter.service;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.exception.BaseException;

import java.util.List;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface OptionService {

    List<Option> listOptions( long voteId) throws BaseException;



    List<Option> createOption(long userId, long voteId, List<Option> options) throws BaseException;


}
