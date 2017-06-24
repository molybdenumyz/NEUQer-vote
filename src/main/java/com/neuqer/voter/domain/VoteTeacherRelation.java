package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/23.
 */
public class VoteTeacherRelation {
    private long userId;
    private long voteId;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }
}
