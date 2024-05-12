package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.CoachRequest;
import com.university.sportapp.dto.response.CoachResponse;
import com.university.sportapp.models.Coach;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/coaches")
public class CoachController extends BaseController<CoachRequest, CoachResponse, Coach> {
    public CoachController(BaseService<Coach> baseService, BaseConverter<CoachRequest, CoachResponse, Coach> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, CoachRequest coachRequest) {
        Coach coach = baseConverter.dtoToEntity(coachRequest);
        coach.setId(id);
        baseService.update(coach);
    }
}
