package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.TrainingSession;
import org.springframework.stereotype.Service;

@Service
public class TrainingSessionService extends BaseService<TrainingSession> {
    public TrainingSessionService(BaseDao<TrainingSession> baseDao) {
        super(baseDao);
    }
}
