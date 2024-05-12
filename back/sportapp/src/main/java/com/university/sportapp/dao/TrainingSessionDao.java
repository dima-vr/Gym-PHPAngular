package com.university.sportapp.dao;

import com.university.sportapp.models.TrainingSession;
import com.university.sportapp.repositories.TrainingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class TrainingSessionDao extends BaseDao<TrainingSession> {
    public TrainingSessionDao(JpaRepository<TrainingSession, Long> repository) {
        super(repository);
    }
}
