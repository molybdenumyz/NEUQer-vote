package com.neuqer.voter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.domain.VoteRecord;

import java.util.List;


/**
 * Created by yinzhe on 17/5/9.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoteInfoResponse {

    private VoteShow voteShow;
    private List<Option> options;
    private List<VoteRecord> records;
    public VoteInfoResponse(Vote vote,List<Option> options,List<VoteRecord> records) {
        this.voteShow = new VoteShow();
        voteShow.setCreatorId(vote.getCreatorId());
        voteShow.setId(vote.getId());
        voteShow.setTitle(vote.getTitle());
        voteShow.setVisibility(vote.isVisibilityLimit());
        voteShow.setType(vote.getType());
        voteShow.setMax(vote.getMax());
        voteShow.setQaPath(vote.getQaPath());
        voteShow.setEndTime(vote.getEndTime());
        voteShow.setStartTime(vote.getStartTime());
        voteShow.setFlag(vote.getFlag());
        voteShow.setParticipatorNum(vote.getParticipatorNum());
        this.options = options;
        this.records = records;
    }

    public List<VoteRecord> getRecords() {
        return records;
    }

    public void setRecords(List<VoteRecord> records) {
        this.records = records;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public VoteShow getVoteShow() {
        return voteShow;
    }

    public void setVoteShow(VoteInfoResponse.VoteShow voteShow) {
        this.voteShow = voteShow;
    }

    public  class  VoteShow {
        private long id;
        private String title;
        private boolean visibility;
        private long creatorId;
        private Integer type;
        private Integer max;
        private String qaPath;
        private long startTime;
        private long endTime;
        private Integer flag;
        private int participatorNum;


        public int getParticipatorNum() {

            return participatorNum;
        }

        public void setParticipatorNum(int participatorNum) {
            this.participatorNum = participatorNum;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVisibility() {
            return visibility;
        }

        public void setVisibility(boolean visibility) {
            this.visibility = visibility;
        }

        public long getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(long creatorId) {
            this.creatorId = creatorId;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public String getQaPath() {
            return qaPath;
        }

        public void setQaPath(String qaPath) {
            this.qaPath = qaPath;
        }
    }
}
