package com.neuqer.voter.service.impl;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.Option.OptionNotExistException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.mapper.OptionMapper;
import com.neuqer.voter.service.CreatorService;
import com.neuqer.voter.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hotown on 17/3/22.
 */
@Service("OptionService")
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionMapper optionMapper;


    @Override
    public List<Option> listOptions( long voteId) throws BaseException {

        List<Option> options = optionMapper.listOptions(voteId);
        return options;
    }



    @Override
    public List<Option> createOption(long userId, long voteId, List<Option> options) throws BaseException {


        int row = optionMapper.createOption(options);

        if (row < 1) {
            throw new UnknownException();
        } else {
            return options;
        }
    }


}
