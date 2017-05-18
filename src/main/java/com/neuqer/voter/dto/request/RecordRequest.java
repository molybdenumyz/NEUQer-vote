package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.Option;
import com.neuqer.voter.domain.Vote;
import com.neuqer.voter.dto.response.RecordsResponse;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by yinzhe on 17/5/19.
 */
public class RecordRequest {
    @NotNull
    private long id;

    @NotBlank
    private String title;

    @NotNull
    private int type;

    @NotEmpty
    private List<Option> options;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }


}
