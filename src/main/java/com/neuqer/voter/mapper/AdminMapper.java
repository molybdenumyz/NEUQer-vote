package com.neuqer.voter.mapper;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.UpdateVote;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteNeed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yinzhe on 17/5/10.
 */
public interface AdminMapper {

    Integer isAdmin(@Param("id") long id);
    Integer upToAdmin(@Param("id") long id);
    Vote getVote(@Param("id") long id);
    Vote getVoteWithTrashed(@Param("id") long id);
    Long getCreator(@Param("voteId") long voteId);
    List<Vote> getVoteByCreator(@Param("creatorId") long creatorId);
    List<VoteNeed> getAllVote();
    Vote getVoteByTitle(@Param("title") String title);

    Integer createVote(Vote vote);

    Integer updateVoteTitle(@Param("id") long id, @Param("title") String title);
    Integer updateVotePassword(@Param("id") long id, @Param("password") String password);
    Integer updateVoteParticipatorLimit(@Param("id") long id, @Param("participatorLimit") int participatorLimit);
    Integer updateVoteParticipatorNum(@Param("id") long id);

    Integer deleteVote(@Param("id") long id);
    Integer forceDeleteVote(@Param("id") long id);


    Integer isParticipatorLimit(@Param("id") long id);
    Boolean isVisibilityLimit(@Param("id") long id);
    //Boolean isAnonymous(@Param("id") long id);

    Long isStart(@Param("id") long id);
    Long isEnd(@Param("id") long id);

    Integer insertQaPath(@Param("qa_path") String qa_path,@Param("id") long id);

    Integer disVisibility(@Param("id") long id);

    Integer updateVote(Vote vote);

    Integer updateVoteOption(Option option);
}
