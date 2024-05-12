package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.WorkoutRequest;
import com.university.sportapp.dto.response.WorkoutResponse;
import com.university.sportapp.models.Workout;
import org.springframework.stereotype.Component;

@Component
public class WorkoutConverter extends BaseConverter<WorkoutRequest, WorkoutResponse, Workout> {
    @Override
    protected Class<Workout> getEntityClass() {
        return Workout.class;
    }

    @Override
    protected Class<WorkoutResponse> getResponseClass() {
        return WorkoutResponse.class;
    }
}
