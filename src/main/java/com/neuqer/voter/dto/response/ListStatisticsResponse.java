package com.neuqer.voter.dto.response;

import java.util.List;

/**
 * Created by yinzhe on 17/6/24.
 */
public class ListStatisticsResponse {
    private String Activity;
    private List<StatisticsResponse> statistics;

    public ListStatisticsResponse(String activity) {
        Activity = activity;
    }

    public ListStatisticsResponse(String activity, List<StatisticsResponse> statistics) {
        Activity = activity;
        this.statistics = statistics;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }

    public List<StatisticsResponse> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<StatisticsResponse> statistics) {
        this.statistics = statistics;
    }
}
