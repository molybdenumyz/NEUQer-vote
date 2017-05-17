package com.neuqer.voter.domain;

/**
 * Created by Hotown on 17/3/17.
 */
public class Vote {

    /**
     * id
     */
    private long id;

    /**
     * 投票主题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否匿名
     */
    private boolean anonymous;

    /**
     * 参与者人数限制
     */
    private int participatorLimit;

    /**
     * 私有度，表示投票是否加密
     */
    private boolean visibilityLimit;

    /**
     * 投票开始时间
     */
    private long startTime;

    /**
     * 投票结束时间
     */
    private long endTime;

    /**
     * 创建者id
     */
    private long creatorId;

    /**
     * 创建时间
     */
    private long createdAt;

    /**
     * 更新时间
     */
    private long updatedAt;

    /**
     * 软删除
     */
    private boolean isDeleted;

    /**
     * 私有投票密码
     */
    private String password;

    /**
     * 参与者总数
     */
    private int participatorNum;

    /**
     * 二维码链接
     */
    private String qaPath;

    /**
     * 投票类型
     */
    private Integer type;

    /**
     * 选择最大数
     */
    private Integer max;

    private Integer flag = 0;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public int getParticipatorLimit() {
        return participatorLimit;
    }

    public void setParticipatorLimit(int participatorLimit) {
        this.participatorLimit = participatorLimit;
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

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getParticipatorNum() {
        return participatorNum;
    }

    public void setParticipatorNum(int participatorNum) {
        this.participatorNum = participatorNum;
    }

    public String getQaPath() {
        return qaPath;
    }

    public void setQaPath(String qaPath) {
        this.qaPath = qaPath;
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

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", anonymous=" + anonymous +
                ", participatorLimit=" + participatorLimit +
                ", visibilityLimit=" + visibilityLimit +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isDeleted=" + isDeleted +
                ", password='" + password + '\'' +
                ", participatorNum=" + participatorNum +
                ", qaPath='" + qaPath + '\'' +
                ", type=" + type +
                '}';
    }
}
