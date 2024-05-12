package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.dao.UserDao;
import com.university.sportapp.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    private final UserDao userDao;

    public UserService(BaseDao<User> baseDao, UserDao userDao) {
        super(baseDao);
        this.userDao = userDao;
    }

    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }
}
