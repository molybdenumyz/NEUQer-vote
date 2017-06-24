package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public interface RelationMapper {
    Integer createVoteProjectRelation(VoteProjectRelation voteProjectRelation);

    Integer createVoteMaringRelation(VoteMaringRelation voteMaringRelation);

    Integer createVoteTeacherRelation(VoteTeacherRelation voteTeacherRelation);

    Integer createActivityMaringRelation(ActivityMaringRelation activityMaringRelation);

    Integer createActivityProjectRelation(ActivityProject activityProject);

    Long findProjectIdByVoteId(@Param("voteId") Long voteId);

    List<Statis> findStaticsByUserId(@Param("userId") long userId,@Param("proId") long proId);

    List<Long> findUserByActivityId(@Param("acId") long acId);

    List<Project> findProByAcId(@Param("acId") long acId);
}
