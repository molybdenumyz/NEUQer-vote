package com.neuqer.voter.service;

import com.neuqer.voter.domain.Derecord;
import com.neuqer.voter.domain.Maring;
import com.neuqer.voter.domain.VoteNeed;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public interface TeacherService {
    List<VoteNeed> allVoteToTeacher(Long userId,int page,int rows);

    List<Maring> MaringToVote(long voteId);

    boolean SubmitToDerecord(Derecord derecord);
}
