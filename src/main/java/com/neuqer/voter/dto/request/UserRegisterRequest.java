package com.neuqer.voter.dto.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by lumin on 17/3/17.
 */
public class UserRegisterRequest {
    @NotBlank
    private String mobile;
    @NotBlank
    private String password;
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterRequest{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
