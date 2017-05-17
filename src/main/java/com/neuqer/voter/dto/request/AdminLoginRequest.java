package com.neuqer.voter.dto.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by yinzhe on 17/5/11.
 */
public class AdminLoginRequest {
    @NotBlank
    private String mobile;
    @NotBlank
    private String password;
    @NotNull
    private int client;

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
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
}
