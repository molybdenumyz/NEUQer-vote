package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/5/12.
 */
public class VoteNeed {
    private long id;
    private String title;
    private long startTime;
    private long endTime;
    private int type;
    private int max;
    private long updatedAt;
    private String mobile;
    private int participatorNum;
    private Integer flag;


    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getParticipatorNum() {
        return participatorNum;
    }

    public void setParticipatorNum(int participatorNum) {
        this.participatorNum = participatorNum;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "VoteNeed{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", type=" + type +
                ", max=" + max +
                ", mobile='" + mobile + '\'' +
                ", flag=" + flag +
                ", participatorNum=" + participatorNum +
                '}';
    }
}
