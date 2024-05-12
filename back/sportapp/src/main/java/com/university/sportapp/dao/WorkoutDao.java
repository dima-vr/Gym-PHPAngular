package com.university.sportapp.dao;

import com.university.sportapp.models.Workout;
import com.university.sportapp.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class WorkoutDao extends BaseDao<Workout> {
    public WorkoutDao(JpaRepository<Workout, Long> repository) {
        super(repository);
    }
}
