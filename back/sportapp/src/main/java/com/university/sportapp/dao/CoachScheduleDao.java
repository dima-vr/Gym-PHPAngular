package com.university.sportapp.dao;

import com.university.sportapp.models.CoachSchedule;
import com.university.sportapp.repositories.CoachScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CoachScheduleDao extends BaseDao<CoachSchedule> {
    public CoachScheduleDao(JpaRepository<CoachSchedule, Long> repository) {
        super(repository);
    }
}
