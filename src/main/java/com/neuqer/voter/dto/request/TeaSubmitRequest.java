package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.Maring;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class TeaSubmitRequest {
    //这里的score为所打的分数
    private List<Maring> options;

    private long voteId;

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public List<Maring> getOptions() {
        return options;
    }

    public void setOptions(List<Maring> options) {
        this.options = options;
    }
}
