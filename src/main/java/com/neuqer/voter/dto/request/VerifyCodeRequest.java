package com.neuqer.voter.dto.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by yinzhe on 17/5/9.
 */
public class VerifyCodeRequest {

    @NotNull
    private Integer type;

    @NotBlank
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VerifyCodeRequest{" +
                "type=" + type +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
