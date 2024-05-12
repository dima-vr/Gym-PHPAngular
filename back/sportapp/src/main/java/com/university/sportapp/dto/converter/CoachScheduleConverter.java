package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.CoachScheduleRequest;
import com.university.sportapp.dto.response.CoachScheduleResponse;
import com.university.sportapp.models.CoachSchedule;
import org.springframework.stereotype.Component;

@Component
public class CoachScheduleConverter extends BaseConverter<CoachScheduleRequest, CoachScheduleResponse, CoachSchedule> {
    @Override
    protected Class<CoachSchedule> getEntityClass() {
        return CoachSchedule.class;
    }

    @Override
    protected Class<CoachScheduleResponse> getResponseClass() {
        return CoachScheduleResponse.class;
    }
}
