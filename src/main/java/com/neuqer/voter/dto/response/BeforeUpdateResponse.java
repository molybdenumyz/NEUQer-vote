package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.Vote;

import java.util.List;

/**
 * Created by yinzhe on 17/5/12.
 */
public class BeforeUpdateResponse {
    private VoteShow voteShow;
    private List<Option> options;

    public BeforeUpdateResponse(Vote vote,List<Option> options) {
        this.voteShow = new VoteShow();
        voteShow.setCreatorId(vote.getCreatorId());
        voteShow.setId(vote.getId());
        voteShow.setTitle(vote.getTitle());
        voteShow.setVisibility(vote.isVisibilityLimit());
        voteShow.setType(vote.getType());
        voteShow.setFlag(vote.getFlag());
        this.options = options;
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

    public void setVoteShow(VoteShow voteShow) {
        this.voteShow = voteShow;
    }

    public  class  VoteShow {
        private long id;
        private String title;
        private boolean visibility;
        private long creatorId;
        private Integer type;
        private Integer flag;

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

        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }
    }
}
