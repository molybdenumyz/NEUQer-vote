package com.neuqer.voter.dto.response;

import com.neuqer.voter.domain.Maring;

import java.util.List;

/**
 * Created by yinzhe on 17/6/23.
 */
public class MaringResponse {

    private long ActivityId;

    private List<Long> maringIds;

    public long getActivityId() {
        return ActivityId;
    }

    public void setActivityId(long activityId) {
        ActivityId = activityId;
    }

    public MaringResponse(long activityId, List<Long> maringIds) {
        ActivityId = activityId;
        this.maringIds = maringIds;
    }

    public List<Long> getMaringIds() {
        return maringIds;
    }

    public void setMaringIds(List<Long> maringIds) {
        this.maringIds = maringIds;
    }
}
