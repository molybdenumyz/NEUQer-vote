package com.neuqer.voter.domain;

public class QRCode {

    private final int width = 300;

    private final int height = 300;

    private final String format = "png";

    private String voteName;

    private String contents;

    private long voteId;

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    private final String logo_path = "/Users/Hotown/WorkSpace/java_project/vote_be/QRCode" + "/" + "logo.jpg";

    public String getLogo_path() {
        return logo_path;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getFormat() {
        return format;
    }


}

