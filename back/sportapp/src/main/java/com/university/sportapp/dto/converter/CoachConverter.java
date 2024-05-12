package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.CoachRequest;
import com.university.sportapp.dto.response.CoachResponse;
import com.university.sportapp.models.Coach;
import org.springframework.stereotype.Component;

@Component
public class CoachConverter extends BaseConverter<CoachRequest, CoachResponse, Coach> {
    @Override
    protected Class<Coach> getEntityClass() {
        return Coach.class;
    }

    @Override
    protected Class<CoachResponse> getResponseClass() {
        return CoachResponse.class;
    }
}
