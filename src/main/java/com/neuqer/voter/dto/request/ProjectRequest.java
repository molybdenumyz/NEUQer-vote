package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.Project;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class ProjectRequest {

    @NotNull
    private long activityId;
    @NotNull
    private long startTime;

    @NotNull
    private long endTime;

    private List<Long> maringId;

    private List<Project> projectList;

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Long> getMaringId() {
        return maringId;
    }

    public void setMaringId(List<Long> maringId) {
        this.maringId = maringId;
    }



    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }
}
