package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.WorkoutRequest;
import com.university.sportapp.dto.response.WorkoutResponse;
import com.university.sportapp.models.Workout;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/workout")
public class WorkoutController extends BaseController<WorkoutRequest, WorkoutResponse, Workout> {
    public WorkoutController(BaseService<Workout> baseService, BaseConverter<WorkoutRequest, WorkoutResponse, Workout> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, WorkoutRequest workoutRequest) {
        Workout workout = baseConverter.dtoToEntity(workoutRequest);
        workout.setId(id);
        baseService.update(workout);
    }
}
