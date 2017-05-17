package com.neuqer.voter.domain;
/**
 * Created by yinzhe on 17/5/9.
 */
public class Option {

    private long id;
    private long voteId;
    private String title;
    private Integer value;
    private int num;



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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", title='" + title + '\'' +
                ", value=" + value +
                ", num=" + num +
                '}';
    }
}
