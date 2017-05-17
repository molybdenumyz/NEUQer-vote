package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteNeed;
import com.neuqer.voter.domain.VoteRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hotown on 17/3/17.
 */
public interface VoteMapper {

    Vote getVote(@Param("id") long id);
    Long getCreator(@Param("voteId") long voteId);
    List<VoteNeed> getAllVote();
    Vote getVoteByTitle(@Param("creatorId") long creatorId, @Param("title") String title);

    Long isStart(@Param("id") long id);
    Long isEnd(@Param("id") long id);

    Integer insertQaPath(@Param("qa_path") String qa_path,@Param("id") long id);

    Integer updateVoteParticipatorNum(@Param("id") long id);
}
