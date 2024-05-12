package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.GoalRequest;
import com.university.sportapp.dto.response.GoalResponse;
import com.university.sportapp.models.Goal;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/goals")
public class GoalController extends BaseController<GoalRequest, GoalResponse, Goal> {
    public GoalController(BaseService<Goal> baseService, BaseConverter<GoalRequest, GoalResponse, Goal> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, GoalRequest goalRequest) {
        Goal goal = baseConverter.dtoToEntity(goalRequest);
        goal.setId(id);
        baseService.update(goal);
    }
}
