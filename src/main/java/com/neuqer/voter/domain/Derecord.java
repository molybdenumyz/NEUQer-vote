package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/23.
 */
public class Derecord {
    private long id;
    private long projectId;
    private long voteId;
    private long value;
    private long maringId;
    private long userId;
    private long createAt;


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

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getMaringId() {
        return maringId;
    }

    public void setMaringId(long maringId) {
        this.maringId = maringId;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }
}
