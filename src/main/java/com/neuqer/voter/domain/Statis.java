package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/24.
 */
public class Statis {

    private String title;
    private Integer value;
    private long projectId;
    private long maringId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getMaringId() {
        return maringId;
    }

    public void setMaringId(long maringId) {
        this.maringId = maringId;
    }
}
