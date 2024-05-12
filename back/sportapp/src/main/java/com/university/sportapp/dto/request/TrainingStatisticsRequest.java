package com.university.sportapp.dto.request;

import com.university.sportapp.models.User;
import com.university.sportapp.models.Workout;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TrainingStatisticsRequest {
    private Long id;
    private User user;
    private LocalDate trainingDate;
    private Workout workout;
    private Integer durationMinutes;
    private List<String> achievements;
}
