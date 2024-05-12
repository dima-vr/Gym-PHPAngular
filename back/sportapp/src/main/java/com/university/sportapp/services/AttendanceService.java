package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.models.Attendance;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService extends BaseService<Attendance> {
    public AttendanceService(BaseDao<Attendance> baseDao) {
        super(baseDao);
    }
}
