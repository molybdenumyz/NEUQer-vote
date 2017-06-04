package com.neuqer.voter.domain;

public class VoteRecord {

    private long id;

    private long optionId;

    private long voteId;

    private int value;

    private long createAt;

    private long updateAt;

    private long userId;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
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
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}
