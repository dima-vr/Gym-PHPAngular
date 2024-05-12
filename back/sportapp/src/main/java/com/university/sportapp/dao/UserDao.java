package com.university.sportapp.dao;

import com.university.sportapp.models.User;
import com.university.sportapp.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao extends BaseDao<User> {
    public UserDao(JpaRepository<User, Long> repository) {
        super(repository);
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = ((UserRepository) repository).findByUsername(username);
        return optionalUser.orElse(null);
    }
}
