package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.BaseConverter;
import com.university.sportapp.dto.request.AttendanceRequest;
import com.university.sportapp.dto.response.AttendanceResponse;
import com.university.sportapp.models.Attendance;
import com.university.sportapp.services.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/attendance")
public class AttendanceController extends BaseController<AttendanceRequest, AttendanceResponse, Attendance> {
    public AttendanceController(BaseService<Attendance> baseService, BaseConverter<AttendanceRequest, AttendanceResponse, Attendance> baseConverter) {
        super(baseService, baseConverter);
    }

    @Override
    public void update(long id, AttendanceRequest attendanceRequest) {
        Attendance attendance = baseConverter.dtoToEntity(attendanceRequest);
        attendance.setId(id);
        baseService.update(attendance);
    }
}
