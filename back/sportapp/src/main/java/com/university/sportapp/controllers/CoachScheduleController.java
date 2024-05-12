package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.CoachScheduleRequest;
import com.university.sportapp.dto.response.CoachScheduleResponse;
import com.university.sportapp.models.CoachSchedule;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/coachSchedule")
public class CoachScheduleController extends BaseController<CoachScheduleRequest, CoachScheduleResponse, CoachSchedule> {
    public CoachScheduleController(BaseService<CoachSchedule> baseService, BaseConverter<CoachScheduleRequest, CoachScheduleResponse, CoachSchedule> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, CoachScheduleRequest coachScheduleRequest) {
        CoachSchedule coachSchedule = baseConverter.dtoToEntity(coachScheduleRequest);
        coachSchedule.setId(id);
        baseService.update(coachSchedule);
    }
}
