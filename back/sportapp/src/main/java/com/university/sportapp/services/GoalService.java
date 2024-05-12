package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.Goal;
import org.springframework.stereotype.Service;

@Service
public class GoalService extends BaseService<Goal> {
    public GoalService(BaseDao<Goal> baseDao) {
        super(baseDao);
    }
}
