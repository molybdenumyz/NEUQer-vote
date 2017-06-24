package com.neuqer.voter.domain;

/**
 * Created by yinzhe on 17/6/23.
 */
public class Project {
    private Long id;
    private String nameZh;
    private String nameEg;
    private String stuId;
    private String stuName;
    private String hold;
    private Long createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getNameEg() {
        return nameEg;
    }

    public void setNameEg(String nameEg) {
        this.nameEg = nameEg;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", nameZh='" + nameZh + '\'' +
                ", nameEg='" + nameEg + '\'' +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", hold='" + hold + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
