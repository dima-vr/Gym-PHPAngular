package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.Workout;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService extends BaseService<Workout> {
    public WorkoutService(BaseDao<Workout> baseDao) {
        super(baseDao);
    }
}
