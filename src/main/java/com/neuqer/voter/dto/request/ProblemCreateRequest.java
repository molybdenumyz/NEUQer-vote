package com.neuqer.voter.dto.request;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Hotown on 17/3/23.
 */
public class ProblemCreateRequest {

    private String title;

    @NotNull
    private int voteId;

    @NotNull
    private int type;

    private String description;

    private List<OptionCreateRequest> options;

    public List<OptionCreateRequest> getOptions() {
        return options;
    }

    public void setOptions(List<OptionCreateRequest> options) {
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProblemCreateRequest{" +
                "title='" + title + '\'' +
                ", voteId=" + voteId +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", options=" + options +
                '}';
    }
}
