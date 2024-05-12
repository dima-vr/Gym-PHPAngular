package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.UserRequest;
import com.university.sportapp.dto.response.UserResponse;
import com.university.sportapp.models.User;
import com.university.sportapp.services.BaseService;
import com.university.sportapp.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserRequest, UserResponse, User> {
    public UserController(BaseService<User> baseService, BaseConverter<UserRequest, UserResponse, User> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, UserRequest userRequest) {
        User user = baseConverter.dtoToEntity(userRequest);
        user.setId(id);
        baseService.update(user);
    }
}
