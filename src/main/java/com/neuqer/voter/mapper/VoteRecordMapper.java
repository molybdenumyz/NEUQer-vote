package com.neuqer.voter.mapper;


import java.util.List;

import com.neuqer.voter.domain.VoteRecord;
import org.apache.ibatis.annotations.Param;

public interface VoteRecordMapper {

    Integer addRecord(VoteRecord voteRecord);

    List<VoteRecord> findRecord(@Param("voteId") long voteId,@Param("userId") long userId);

    List<Integer> findUserValue(@Param("voteId") long voteId,@Param("optionId") long optionId);

    List<Long> findUserList(@Param("voteId") long voteId);

    List<VoteRecord> findThisUserValue(@Param("voteId") long voteId,@Param("userId") long userId);

}
