package com.neuqer.voter.dto.response;

/**
 * Created by yinzhe on 17/4/10.
 */
public class EnCodeResponse {
    public EnCodeResponse(String path) {
        this.path = "123.207.171.244/QRCode/" + path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
