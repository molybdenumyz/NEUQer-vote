package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.Teacher;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class RelationRequest {
    private List<Long> voteIds;
    private List<Teacher> teachers;

    public List<Long> getVoteIds() {
        return voteIds;
    }

    public void setVoteIds(List<Long> voteIds) {
        this.voteIds = voteIds;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
