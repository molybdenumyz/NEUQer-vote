package com.neuqer.voter.dto.request;

import com.neuqer.voter.common.Utils;

/**
 * Created by yinzhe on 17/5/20.
 */
public class FindLikeRequest {
    private long createTimeFrom = -1;

    private long createTimeTo= -1;

    private long startTimeFrom = -1;

    private long startTimeTo = -1;

    private String title;

    private String mobile;

    private int flag = -1;

    private int visibility = -1;

    private long now = Utils.createTimeStamp();

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(long createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public long getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(long createTimeTo) {
        this.createTimeTo = createTimeTo;
    }

    public long getStartTimeFrom() {
        return startTimeFrom;
    }

    public void setStartTimeFrom(long startTimeFrom) {
        this.startTimeFrom = startTimeFrom;
    }

    public long getStartTimeTo() {
        return startTimeTo;
    }

    public void setStartTimeTo(long startTimeTo) {
        this.startTimeTo = startTimeTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int isVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
