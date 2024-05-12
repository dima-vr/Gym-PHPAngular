package com.university.sportapp.dao;

import com.university.sportapp.models.Role;
import com.university.sportapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleDao extends BaseDao<Role> {
    public RoleDao(JpaRepository<Role, Long> repository) {
        super(repository);
    }
}
