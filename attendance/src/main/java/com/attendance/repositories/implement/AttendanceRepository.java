package com.attendance.repositories.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.attendance.context.AttendanceContext;
import com.attendance.models.Attendance;
import com.attendance.repositories.interfaces.IAttendanceRepository;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class AttendanceRepository implements IAttendanceRepository{
  
 private final AttendanceContext _attendanceContext;

  @Override
  public Attendance save(Attendance attendance) {
    
    return _attendanceContext.save(attendance);

  }

  @Override
  public List<Attendance> findAll() {
    return _attendanceContext.findAll();
  }

  @Override
  public Attendance findByCustomerIdAndEmployeeId(long customerId, long employeeId) {
    return _attendanceContext.findByCustomerAndEmployee(customerId, employeeId);
  }

  @Override
  public Attendance update(Attendance attendance) {
    return _attendanceContext.save(attendance);
  }

  

}
