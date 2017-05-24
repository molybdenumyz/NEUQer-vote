package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.VoteRecord;

import java.util.List;

/**
 * Created by yinzhe on 17/5/24.
 */
public class OptionValue {

        private long id;
        private long voteId;
        private String title;
        private int sum;
        private int num;
        private List<Integer> voteRecords;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

    public List<Integer> getVoteRecords() {
        return voteRecords;
    }

    public void setVoteRecords(List<Integer> voteRecords) {
        this.voteRecords = voteRecords;
    }
}
