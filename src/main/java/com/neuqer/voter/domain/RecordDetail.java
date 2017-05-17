package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/4/23.
 */
public class RecordDetail {

        private int voteId;

        private int type;

        private long problemId;

        private String problemTitle;

        private String problemDescription;

        private long Id;

        private String value;

        private int num;

        private boolean isDeleted;

        public long getProblemId() {
            return problemId;
        }

        public void setProblemId(long problemId) {
            this.problemId = problemId;
        }

        public String getProblemTitle() {
            return problemTitle;
        }

        public void setProblemTitle(String problemTitle) {
            this.problemTitle = problemTitle;
        }

        public String getProblemDescription() {
            return problemDescription;
        }

        public void setProblemDescription(String problemDescription) {
            this.problemDescription = problemDescription;
        }


        public long getOptionId() {
            return Id;
        }

        public void setOptionId(long id) {
            Id = id;
        }

        public String getValue() {
                return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }

         public int getType() {
             return type;
        }

        public void setType(int type) {
             this.type = type;
        }

        public int getVoteId() {
            return voteId;
        }

        public void setVoteId(int voteId) {
            this.voteId = voteId;
        }

    @Override
    public String toString() {
        return "RecordDetail{" +
                "voteId=" + voteId +
                ", type=" + type +
                ", problemId=" + problemId +
                ", problemTitle='" + problemTitle + '\'' +
                ", problemDescription='" + problemDescription + '\'' +
                ", OptionId=" + Id +
                ", value='" + value + '\'' +
                ", num=" + num +
                ", isDeleted=" + isDeleted +
                '}';
    }
}


