package com.university.sportapp.dto.response;

import com.university.sportapp.models.User;
import com.university.sportapp.models.Workout;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TrainingStatisticsResponse {
    private Long id;
    private User user;
    private LocalDate trainingDate;
    private Workout workout;
    private Integer durationMinutes;
    private List<String> achievements;
}
