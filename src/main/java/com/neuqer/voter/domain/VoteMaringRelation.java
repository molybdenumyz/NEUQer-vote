package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/23.
 */
public class VoteMaringRelation {
    private long id;
    private long voteId;
    private long maringId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public long getMaringId() {
        return maringId;
    }

    public void setMaringId(long maringId) {
        this.maringId = maringId;
    }

    @Override
    public String toString() {
        return "VoteMaringRelation{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", maringId=" + maringId +
                '}';
    }
}
