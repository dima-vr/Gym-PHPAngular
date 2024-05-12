package com.university.sportapp.dto.converter;

import com.university.sportapp.dto.request.AttendanceRequest;
import com.university.sportapp.dto.response.AttendanceResponse;
import com.university.sportapp.models.Attendance;
import org.springframework.stereotype.Component;

@Component
public class AttendanceConverter extends BaseConverter<AttendanceRequest, AttendanceResponse, Attendance> {

    @Override
    protected Class<Attendance> getEntityClass() {
        return Attendance.class;
    }

    @Override
    protected Class<AttendanceResponse> getResponseClass() {
        return AttendanceResponse.class;
    }
}
