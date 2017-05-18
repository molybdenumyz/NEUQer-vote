package com.neuqer.voter.dto.response;

/**
 * Created by yinzhe on 17/5/19.
 */
public class FilePathResponse {
    private  String path;

    public FilePathResponse(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
