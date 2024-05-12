package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.TrainingStatisticsRequest;
import com.university.sportapp.dto.response.TrainingStatisticsResponse;
import com.university.sportapp.models.TrainingStatistics;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/trainingStatistics")
public class TrainingStatisticsController extends BaseController<TrainingStatisticsRequest, TrainingStatisticsResponse, TrainingStatistics> {
    public TrainingStatisticsController(BaseService<TrainingStatistics> baseService, BaseConverter<TrainingStatisticsRequest, TrainingStatisticsResponse, TrainingStatistics> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, TrainingStatisticsRequest trainingStatisticsRequest) {
        TrainingStatistics trainingStatistics = baseConverter.dtoToEntity(trainingStatisticsRequest);
        trainingStatistics.setId(id);
        baseService.update(trainingStatistics);
    }
}
