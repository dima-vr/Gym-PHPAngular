package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.Coach;
import org.springframework.stereotype.Service;

@Service
public class CoachService extends BaseService<Coach> {
    public CoachService(BaseDao<Coach> baseDao) {
        super(baseDao);
    }
}
