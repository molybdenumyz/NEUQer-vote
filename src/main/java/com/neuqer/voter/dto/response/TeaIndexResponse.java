package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.VoteNeed;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class TeaIndexResponse {
    private List<VoteNeed> voteNeeds;

    public TeaIndexResponse(List<VoteNeed> voteNeeds) {
        this.voteNeeds = voteNeeds;
    }

    public List<VoteNeed> getVoteNeeds() {
        return voteNeeds;
    }

    public void setVoteNeeds(List<VoteNeed> voteNeeds) {
        this.voteNeeds = voteNeeds;
    }
}
