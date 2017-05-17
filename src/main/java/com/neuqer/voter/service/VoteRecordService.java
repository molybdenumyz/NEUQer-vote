package com.neuqer.voter.service;

import java.util.List;

import com.neuqer.voter.domain.*;
import com.neuqer.voter.exception.BaseException;

public interface VoteRecordService {
	
	long voterCount(long voteId) throws BaseException;
	
    List<RecordDetail> EachOptionPercent(long voteId);

}
