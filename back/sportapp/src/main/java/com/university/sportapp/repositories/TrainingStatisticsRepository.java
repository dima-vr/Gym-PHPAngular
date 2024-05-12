package com.university.sportapp.repositories;

import com.university.sportapp.models.TrainingStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingStatisticsRepository extends JpaRepository<TrainingStatistics, Long> {
}
