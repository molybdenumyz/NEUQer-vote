package com.neuqer.voter.service;

import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteNeed;
import com.neuqer.voter.domain.VoteRecord;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.Vote.VoteNotExistException;

import java.util.List;

/**
 * Created by yinzhe on 17/5/9.
 */
public interface VoteService {



    Vote getVoteInfo(long id) throws BaseException;

    List<VoteNeed> getAllVote(int page, int rows) throws BaseException;

    boolean joinVote(long id, String password) throws BaseException;

    boolean submitVote(long voteId, long userId,List<VoteRecord> voteRecords) throws BaseException;

    List<VoteNeed> haveVoted(long userId,int page, int rows) throws VoteNotExistException;

    List<VoteRecord> UserValue(long userId,Vote vote);
}
