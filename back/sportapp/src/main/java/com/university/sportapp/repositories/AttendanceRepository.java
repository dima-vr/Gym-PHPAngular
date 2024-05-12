package com.university.sportapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.sportapp.models.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
