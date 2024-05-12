package com.university.sportapp.dto.response;

import com.university.sportapp.models.TrainingSession;
import com.university.sportapp.models.User;
import lombok.Data;

@Data
public class AttendanceResponse {
    private Long id;
    private TrainingSession session;
    private User user;
}
