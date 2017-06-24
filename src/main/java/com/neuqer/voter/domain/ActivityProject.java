package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/24.
 */
public class ActivityProject {
    private long id;
    private long activityId;
    private long projectId;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
