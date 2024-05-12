package com.university.sportapp.dao;

import com.university.sportapp.models.Attendance;
import com.university.sportapp.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class AttendanceDao extends BaseDao<Attendance> {
    public AttendanceDao(JpaRepository<Attendance, Long> repository) {
        super(repository);
    }
}
