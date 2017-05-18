package com.neuqer.voter.service;

import com.neuqer.voter.domain.*;
import com.neuqer.voter.dto.response.ValueRecordResponse;
import com.neuqer.voter.exception.BaseException;
import com.neuqer.voter.exception.UnknownException;
import com.neuqer.voter.exception.Vote.VoteNotExistException;

import java.util.List;

/**
 * Created by yinzhe on 17/5/10.
 */
public interface AdminService {
    boolean isAdmin(long userId);

    boolean upToAdmin(long userId);

    Vote createVote(long userId, Vote vote) throws BaseException;

    Vote getVoteInfo(long id) throws BaseException;

    List<VoteNeed> getAllVote(int page, int rows) throws BaseException;

    boolean deleteVote(long id) throws BaseException;

    boolean disVisibility(long voteId) throws UnknownException, VoteNotExistException;

    User loginAdmin(String userMobile, String password) throws BaseException;

    boolean updateVote(Vote vote, List<Option> options) throws UnknownException;

    List<Option> record(Vote vote) throws UnknownException;

    ValueRecordResponse valueRecord(Vote vote);
}
