package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/23.
 */
public class VoteProjectRelation {
    private Long id;
    private Long voteId;
    private Long proId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "VoteProjectRelation{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", proId=" + proId +
                '}';
    }
}
