package com.neuqer.voter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Hotown on 17/3/24.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoteCreateResponse {
    public VoteCreateResponse(com.neuqer.voter.domain.Vote vote, List<String> option) {
        this.vote = new Vote();
        this.vote.setId(vote.getId());
        this.vote.setTitle(vote.getTitle());
        this.vote.setVisibilityLimit(vote.isVisibilityLimit());
        this.vote.setStartTime(vote.getStartTime());
        this.vote.setEndTime(vote.getEndTime());
        this.vote.setType(vote.getType());
        this.vote.setMax(vote.getMax());
        this.vote.setOptions(option);
    }

    private Vote vote;



    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }



    class Vote {
        private long id;
        private String title;
        private boolean visibilityLimit;
        private long startTime;
        private long endTime;
        private Integer type;
        private Integer max;
        private List<String> options;

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> option) {
            this.options = option;
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

        public boolean isVisibilityLimit() {
            return visibilityLimit;
        }

        public void setVisibilityLimit(boolean visibilityLimit) {
            this.visibilityLimit = visibilityLimit;
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
    }

    @Override
    public String toString() {
        return "VoteCreateResponse{" +
                "vote=" + vote +
                '}';
    }
}
