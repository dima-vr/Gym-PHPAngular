package com.university.sportapp.repositories;

import com.university.sportapp.models.CoachSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachScheduleRepository extends JpaRepository<CoachSchedule, Long> {
}
