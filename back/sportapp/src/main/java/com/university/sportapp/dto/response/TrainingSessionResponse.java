package com.university.sportapp.dto.response;

import com.university.sportapp.models.Coach;
import com.university.sportapp.models.Workout;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TrainingSessionResponse {
    private Long id;
    private Coach coach;
    private LocalDate sessionDate;
    private Workout workout;
}
