package com.neuqer.voter.mapper;


import java.util.List;

import com.neuqer.voter.domain.RecordDetail;
import com.neuqer.voter.domain.VoteRecord;
import org.apache.ibatis.annotations.Param;

import com.neuqer.voter.domain.Option;

public interface VoteRecordMapper {
    List<RecordDetail> getRecordDetail(@Param("vote_id") long voteId);

    Integer addRecord(VoteRecord voteRecord);

    VoteRecord findRecord(@Param("voteId") long voteId,@Param("userId") long userId);

    List<VoteRecord> findUserValue(@Param("voteId") long voteId);
}
