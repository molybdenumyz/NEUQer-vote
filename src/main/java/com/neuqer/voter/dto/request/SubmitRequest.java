package com.neuqer.voter.dto.request;

import com.neuqer.voter.domain.VoteRecord;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by Hotown on 17/3/31.
 */
public class SubmitRequest {

    @NotEmpty
    private List<VoteRecord> records;

    public List<VoteRecord> getRecords() {
        return records;
    }

    public void setRecords(List<VoteRecord> records) {
        this.records = records;
    }

}
