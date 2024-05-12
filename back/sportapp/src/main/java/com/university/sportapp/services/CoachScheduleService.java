package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.CoachSchedule;
import org.springframework.stereotype.Service;

@Service
public class CoachScheduleService extends BaseService<CoachSchedule> {
    public CoachScheduleService(BaseDao<CoachSchedule> baseDao) {
        super(baseDao);
    }
}
