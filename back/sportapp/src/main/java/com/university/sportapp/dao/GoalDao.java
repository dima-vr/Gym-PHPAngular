package com.university.sportapp.dao;

import com.university.sportapp.models.Goal;
import com.university.sportapp.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class GoalDao extends BaseDao<Goal> {
    public GoalDao(JpaRepository<Goal, Long> repository) {
        super(repository);
    }
}
