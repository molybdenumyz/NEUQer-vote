package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/23.
 */
public class ActivityMaringRelation {
    private long id;
    private long activityId;
    private long maringId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getMaringId() {
        return maringId;
    }

    public void setMaringId(Long maringId) {
        this.maringId = maringId;
    }
}
