package com.attendance.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.attendance.dtos.AttendanceDto;
import com.attendance.models.Attendance;
import com.attendance.repositories.interfaces.IAttendanceRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AttendanceServices {

  private final IAttendanceRepository _attendanceRepository;


  public String save(AttendanceDto attendanceDto) {
    Attendance attendance = _attendanceRepository.findByCustomerIdAndEmployeeId(attendanceDto.getCustomerId(), attendanceDto.getEmployeeId());
    if (attendance != null) {
        attendance.setTimeOut(new Timestamp(System.currentTimeMillis()));
        _attendanceRepository.save(attendance);
        return "El empleado con el id " + attendanceDto.getEmployeeId() + " salió a las: " + attendance.getTimeOut();
    } else {
        attendanceDto.setTimeIn(new Timestamp(System.currentTimeMillis()));
        _attendanceRepository.save(new Attendance(0, attendanceDto.getCustomerId(), attendanceDto.getEmployeeId(), attendanceDto.getTimeIn(), 
        attendanceDto.getTimeOut(), attendanceDto.getPhoto()));
        return "El empleado con el id " + attendanceDto.getEmployeeId() + " ingresó a las: " + attendanceDto.getTimeIn();
      }
  }

  public List<Attendance> findAll(){
    return _attendanceRepository.findAll();
  }

  
  
}
