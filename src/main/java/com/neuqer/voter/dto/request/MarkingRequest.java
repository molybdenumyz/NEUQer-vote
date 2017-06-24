package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.Maring;
import com.neuqer.voter.domain.Project;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class MarkingRequest {

    private String title;

    private Long start_time;

    private Long end_time;


    private List<Maring> makingList;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public List<Maring> getMakingList() {
        return makingList;
    }



    public void setMakingList(List<Maring> makingList) {
        this.makingList = makingList;
    }

}
