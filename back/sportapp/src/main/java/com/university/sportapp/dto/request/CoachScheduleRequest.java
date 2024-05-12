package com.university.sportapp.dto.request;

import com.university.sportapp.models.Coach;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CoachScheduleRequest {
    private Long id;
    private Coach coach;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
