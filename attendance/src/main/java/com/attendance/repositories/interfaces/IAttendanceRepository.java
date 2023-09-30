package com.attendance.repositories.interfaces;

import java.util.List;

import com.attendance.models.Attendance;

public interface IAttendanceRepository {

  public Attendance save(Attendance attendance);
  public List<Attendance> findAll();
  public Attendance findByCustomerIdAndEmployeeId(long customerId, long employeeId);
  public Attendance update(Attendance attendance);
}
