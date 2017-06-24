package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.Teacher;

import java.util.List;

/**
 * Created by yinzhe on 17/6/24.
 */
public class downloadTeachersRequest {
    private List<Teacher> teachers;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
