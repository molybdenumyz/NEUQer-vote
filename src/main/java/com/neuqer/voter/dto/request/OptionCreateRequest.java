package com.neuqer.voter.dto.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Hotown on 17/3/25.
 */
public class OptionCreateRequest {


    @NotBlank
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "OptionCreateRequest{" +
                ", title='" + title + '\'' +
                '}';
    }
}
