package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.UserRequest;
import com.university.sportapp.dto.response.UserResponse;
import com.university.sportapp.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<UserRequest, UserResponse, User> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }
}
