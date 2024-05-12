package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.TrainingStatistics;
import org.springframework.stereotype.Service;

@Service
public class TrainingStatisticsService extends BaseService<TrainingStatistics> {
    public TrainingStatisticsService(BaseDao<TrainingStatistics> baseDao) {
        super(baseDao);
    }
}
