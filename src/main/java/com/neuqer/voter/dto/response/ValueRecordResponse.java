package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.VoteRecord;

import java.util.List;

/**
 * Created by yinzhe on 17/5/19.
 */
public class ValueRecordResponse {
    private List<VoteRecord> valuelist;

    private List<Option>options;

    private long voteId;

    private String title;

    private int type;



    public void setValuelist(List<VoteRecord> valuelist) {
        this.valuelist = valuelist;
    }

    public List<VoteRecord> getValuelist() {
        return valuelist;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
