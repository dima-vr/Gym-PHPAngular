package com.university.sportapp.dto.response;

import lombok.Data;

@Data
public class AuthorizationResponse {

    private String token;

    private String refreshToken;

    private int accessTokenLifetimeMinutes;

    private int refreshTokenLifetimeMinutes;

    private UserResponse user;
}
