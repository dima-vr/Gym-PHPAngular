package com.university.sportapp.dao;

import com.university.sportapp.models.Coach;
import com.university.sportapp.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CoachDao extends BaseDao<Coach> {
    public CoachDao(JpaRepository<Coach, Long> repository) {
        super(repository);
    }
}
