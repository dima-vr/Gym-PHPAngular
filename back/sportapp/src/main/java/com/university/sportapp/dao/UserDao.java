package com.university.sportapp.dao;

import com.university.sportapp.models.User;
import com.university.sportapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends BaseDao<User> {
    public UserDao(JpaRepository<User, Long> repository) {
        super(repository);
    }
}
