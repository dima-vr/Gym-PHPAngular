package com.university.sportapp.dto.request;

import com.university.sportapp.models.User;
import lombok.Data;

@Data
public class CoachRequest {
    private Long id;
    private User user;
    private String skillsAndExperience;
}
