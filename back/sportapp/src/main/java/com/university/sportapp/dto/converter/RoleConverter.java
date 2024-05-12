package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.RoleRequest;
import com.university.sportapp.dto.response.RoleResponse;
import com.university.sportapp.models.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter extends BaseConverter<RoleRequest, RoleResponse, Role> {
    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    protected Class<RoleResponse> getResponseClass() {
        return RoleResponse.class;
    }
}
