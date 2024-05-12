package com.university.sportapp.dto.request;

import lombok.Data;

@Data
public class WorkoutRequest {
    private Long id;
    private String type;
    private boolean groupSession;
}
