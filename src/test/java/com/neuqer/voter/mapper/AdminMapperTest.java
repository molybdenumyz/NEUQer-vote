package com.neuqer.voter.mapper;

import com.neuqer.voter.common.Utils;
import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.UpdateVote;
import com.neuqer.voter.domain.Vote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinzhe on 17/5/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest
{
    @Autowired
    AdminMapper adminMapper;

    @Test
    public void updateVoteTest(){
        Vote updateVote = new Vote();
        updateVote.setTitle("nihao");
        updateVote.setId(51);
        Long now = Utils.createTimeStamp();
        updateVote.setEndTime(now+300000000);
        updateVote.setStartTime(now);
        adminMapper.updateVote(updateVote);
    }

    @Test
    public void updateOption(){


        Option option = new Option();
        option.setTitle("updateTest");
        option.setVoteId(52);


        adminMapper.updateVoteOption(option);

    }
}
