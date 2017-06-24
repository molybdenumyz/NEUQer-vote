package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Maring;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class TeaMaringResponse {
    private List<Maring> options;

    public TeaMaringResponse(List<Maring> options) {
        this.options = options;
    }

    public List<Maring> getOptions() {
        return options;
    }

    public void setOptions(List<Maring> options) {
        this.options = options;
    }
}
