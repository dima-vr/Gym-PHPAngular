package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.TrainingStatisticsRequest;
import com.university.sportapp.dto.response.TrainingStatisticsResponse;
import com.university.sportapp.models.TrainingStatistics;
import org.springframework.stereotype.Component;

@Component
public class TrainingStatisticsConverter extends BaseConverter<TrainingStatisticsRequest, TrainingStatisticsResponse, TrainingStatistics> {
    @Override
    protected Class<TrainingStatistics> getEntityClass() {
        return TrainingStatistics.class;
    }

    @Override
    protected Class<TrainingStatisticsResponse> getResponseClass() {
        return TrainingStatisticsResponse.class;
    }
}
