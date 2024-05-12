package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.GoalRequest;
import com.university.sportapp.dto.response.GoalResponse;
import com.university.sportapp.models.Goal;
import org.springframework.stereotype.Component;

@Component
public class GoalConverter extends BaseConverter<GoalRequest, GoalResponse, Goal> {
    @Override
    protected Class<Goal> getEntityClass() {
        return Goal.class;
    }

    @Override
    protected Class<GoalResponse> getResponseClass() {
        return GoalResponse.class;
    }
}
