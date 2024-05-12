package com.university.sportapp.dao;

import com.university.sportapp.models.TrainingStatistics;
import com.university.sportapp.repositories.TrainingStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class TrainingStatisticsDao extends BaseDao<TrainingStatistics> {
    public TrainingStatisticsDao(JpaRepository<TrainingStatistics, Long> repository) {
        super(repository);
    }
}
