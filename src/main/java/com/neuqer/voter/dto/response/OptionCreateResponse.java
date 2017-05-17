package com.neuqer.voter.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.neuqer.voter.domain.Option;

/**
 * Created by Hotown on 17/4/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionCreateResponse {
    public OptionCreateResponse(com.neuqer.voter.domain.Option option) {
       this.setTitle(option.getTitle());
    }

        private String title;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

}
