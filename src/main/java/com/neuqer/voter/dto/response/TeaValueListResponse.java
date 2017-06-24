package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Maring;
import com.neuqer.voter.domain.Statis;

import java.util.List;

/**
 * Created by yinzhe on 17/6/24.
 */
public class TeaValueListResponse {
    private String teacher;

    private List<Statis> detailStatis;



    public TeaValueListResponse(String teacher, List<Statis> detailStatis) {
        this.teacher = teacher;
        this.detailStatis = detailStatis;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Statis> getDetailStatis() {
        return detailStatis;
    }

    public void setDetailStatis(List<Statis> detailStatis) {
        this.detailStatis = detailStatis;
    }
}
