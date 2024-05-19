package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.UserRequest;
import com.university.sportapp.dto.response.UserResponse;
import com.university.sportapp.models.User;
import com.university.sportapp.models.Role;
import com.university.sportapp.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<UserRequest, UserResponse, User> {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public UserConverter(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }

    @Override
    public User dtoToEntity(UserRequest request) {
        User user = new User();
        if (request.getId() != null) {
            user = userService.get(request.getId());
        }
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setHeight(request.getHeight());
        user.setGoals(request.getGoals());
        user.setWeight(request.getWeight());
        user.setProfilePhotoUrl(request.getProfilePhotoUrl());
        user.setPaymentStatus(request.isPaymentStatus());

        if (request.getRole() == null) {
            user.setRole(Role.USER);
        } else {
            user.setRole(request.getRole());
        }

        return user;
    }
}
