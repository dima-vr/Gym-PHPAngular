package com.university.sportapp.dto.request;

import com.university.sportapp.models.Coach;
import com.university.sportapp.models.Workout;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TrainingSessionRequest {
    private Long id;
    private Coach coach;
    private LocalDate sessionDate;
    private Workout workout;
}
