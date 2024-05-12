package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.TrainingSessionRequest;
import com.university.sportapp.dto.response.TrainingSessionResponse;
import com.university.sportapp.models.TrainingSession;
import org.springframework.stereotype.Component;

@Component
public class TrainingSessionConverter extends BaseConverter<TrainingSessionRequest, TrainingSessionResponse, TrainingSession> {
    @Override
    protected Class<TrainingSession> getEntityClass() {
        return TrainingSession.class;
    }

    @Override
    protected Class<TrainingSessionResponse> getResponseClass() {
        return TrainingSessionResponse.class;
    }
}
