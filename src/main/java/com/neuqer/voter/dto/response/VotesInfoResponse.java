package com.neuqer.voter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.neuqer.voter.domain.Vote;

import java.util.List;

/**
 * Created by Hotown on 17/4/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VotesInfoResponse {
    private List<Vote> votes;

    public VotesInfoResponse(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
