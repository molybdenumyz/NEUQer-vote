package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Maring;

import java.util.List;

/**
 * Created by yinzhe on 17/6/24.
 */
public class TeaSubmitResponse {
    private List<Maring> list;

    public TeaSubmitResponse(List<Maring> list) {
        this.list = list;
    }

    public List<Maring> getList() {
        return list;
    }

    public void setList(List<Maring> list) {
        this.list = list;
    }
}
