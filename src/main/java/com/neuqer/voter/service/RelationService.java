package com.neuqer.voter.service;

import com.neuqer.voter.domain.*;

/**
 * Created by yinzhe on 17/6/23.
 */
public interface RelationService {
    boolean createVoteProjectRelation(VoteProjectRelation voteProjectRelation);

    boolean createVoteMaringRelation(VoteMaringRelation voteMaringRelation);

    boolean createVoteTeacherRelation(VoteTeacherRelation voteTeacherRelation);

    boolean createActivityMaringRelation(ActivityMaringRelation activityMaringRelation);

    boolean createActivityProjectRelation(ActivityProject activityProject);
    Long getProjectIdByVoteId(long voteId);
}
