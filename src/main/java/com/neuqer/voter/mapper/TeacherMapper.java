package com.neuqer.voter.mapper;


import com.neuqer.voter.domain.Derecord;
import com.neuqer.voter.domain.Maring;
import com.neuqer.voter.domain.VoteNeed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public interface TeacherMapper {
    List<VoteNeed> getVoteByUserId(@Param("userId") long userId);

    List<Maring> getMaringByVoteId(@Param("voteId") long voteId);

    Integer insertDerecord(Derecord derecord);
}
