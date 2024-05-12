package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    public UserService(BaseDao<User> baseDao) {
        super(baseDao);
    }
}
