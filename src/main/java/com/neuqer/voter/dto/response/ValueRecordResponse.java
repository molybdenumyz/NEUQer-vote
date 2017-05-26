package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.VoteRecord;

import java.util.List;

/**
 * Created by yinzhe on 17/5/19.
 */
public class ValueRecordResponse {
    private List<OptionValue> optionValue;

    private long voteId;

    private String title;

    private int type;

    private int participatorNum;

    public int getParticipatorNum() {
        return participatorNum;
    }

    public void setParticipatorNum(int participatorNum) {
        this.participatorNum = participatorNum;
    }

    public List<OptionValue> getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(List<OptionValue> optionValue) {
        this.optionValue = optionValue;
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
