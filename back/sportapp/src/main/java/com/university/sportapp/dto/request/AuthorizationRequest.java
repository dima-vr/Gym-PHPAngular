package com.university.sportapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorizationRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
