package com.neuqer.voter.dto.response;

import java.util.List;

/**
 * Created by yinzhe on 17/6/24.
 */
public class StatisticsResponse {
    private String nameZh;
    private String nameEg;
    private String stuId;
    private String stuName;
    private String hold;
    private List<TeaValueListResponse> values;


    public StatisticsResponse(String nameZh, String nameEg, String stuId, String stuName, String hold, List<TeaValueListResponse> values) {
        this.nameZh = nameZh;
        this.nameEg = nameEg;
        this.stuId = stuId;
        this.stuName = stuName;
        this.hold = hold;
        this.values = values;
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

    public List<TeaValueListResponse> getValues() {
        return values;
    }

    public void setValues(List<TeaValueListResponse> values) {
        this.values = values;
    }
}
