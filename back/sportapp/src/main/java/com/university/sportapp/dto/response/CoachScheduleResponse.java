package com.university.sportapp.dto.response;

import com.university.sportapp.models.Coach;

import java.time.LocalTime;

public class CoachScheduleResponse {
    private Long id;
    private Coach coach;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
