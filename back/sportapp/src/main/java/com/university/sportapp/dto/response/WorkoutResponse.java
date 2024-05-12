package com.university.sportapp.dto.response;

import lombok.Data;

@Data
public class WorkoutResponse {
    private Long id;
    private String type;
    private boolean groupSession;
}
