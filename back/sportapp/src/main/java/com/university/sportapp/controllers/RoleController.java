package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.RoleRequest;
import com.university.sportapp.dto.response.RoleResponse;
import com.university.sportapp.models.Role;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/roles")
public class RoleController extends BaseController<RoleRequest, RoleResponse, Role> {
    public RoleController(BaseService<Role> baseService, BaseConverter<RoleRequest, RoleResponse, Role> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, RoleRequest roleRequest) {
        Role role = baseConverter.dtoToEntity(roleRequest);
        role.setId(id);
        baseService.update(role);
    }
}
