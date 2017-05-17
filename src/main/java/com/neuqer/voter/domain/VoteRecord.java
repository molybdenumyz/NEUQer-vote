package com.neuqer.voter.domain;

public class VoteRecord {

    private long id;

    private long optionId;

    private long voteId;

    private int value;

    private long createdAt;

    private long updatedAt;

    private long userId;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }



    public long getOptionId() {
        return optionId;
    }


    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }



    public long getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }


    public long getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }


    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "VoteRecord{" +
                "id=" + id +
                ", optionId=" + optionId +
                ", voteId=" + voteId +
                ", value=" + value +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userId=" + userId +
                ", type=" + type +
                '}';
    }
}