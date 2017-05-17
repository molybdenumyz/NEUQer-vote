package com.neuqer.voter.dto.response;

/**
 * Created by yinzhe on 17/4/10.
 */
public class EnCodeResponse {
    public EnCodeResponse(String path) {
        this.path = "192.168.1.219/QRcode/" + path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
