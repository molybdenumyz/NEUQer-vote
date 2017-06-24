package com.neuqer.voter.dto.response;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class ProVoteResponse {
    private List<Long> voteIds;

    public List<Long> getVoteIds() {
        return voteIds;
    }

    public void setVoteIds(List<Long> voteIds) {
        this.voteIds = voteIds;
    }
}
