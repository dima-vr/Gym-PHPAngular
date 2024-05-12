package com.university.sportapp.dto.response;

import com.university.sportapp.models.Goal;
import com.university.sportapp.models.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String profilePhotoUrl;
    private Integer height;
    private Integer weight;
    private boolean paymentStatus;
    private List<Goal> goals;
    private Role role;
}
