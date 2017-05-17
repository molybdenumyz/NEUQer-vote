package com.neuqer.voter.dto.response;

/**
 * Created by yinzhe on 17/5/14.
 */
public class VerifyResponse {
    private String code;
    public VerifyResponse(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
