package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.TrainingSessionRequest;
import com.university.sportapp.dto.response.TrainingSessionResponse;
import com.university.sportapp.models.TrainingSession;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/trainingSessions")
public class TrainingSessionController extends BaseController<TrainingSessionRequest, TrainingSessionResponse, TrainingSession> {
    public TrainingSessionController(BaseService<TrainingSession> baseService, BaseConverter<TrainingSessionRequest, TrainingSessionResponse, TrainingSession> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, TrainingSessionRequest trainingSessionRequest) {
        TrainingSession trainingSession = baseConverter.dtoToEntity(trainingSessionRequest);
        trainingSession.setId(id);
        baseService.update(trainingSession);
    }
}
