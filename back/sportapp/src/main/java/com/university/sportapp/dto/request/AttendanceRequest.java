package com.university.sportapp.dto.request;

import com.university.sportapp.models.TrainingSession;
import com.university.sportapp.models.User;
import lombok.Data;

@Data
public class AttendanceRequest {
    private Long id;
    private TrainingSession session;
    private User user;
}
