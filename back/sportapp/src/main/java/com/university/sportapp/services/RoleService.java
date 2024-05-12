package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role> {
    public RoleService(BaseDao<Role> baseDao) {
        super(baseDao);
    }
}
