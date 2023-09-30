package com.attendance.context;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.attendance.models.Attendance;


public interface AttendanceContext extends JpaRepository<Attendance, Long>{

  @Query(value = "SELECT * FROM attendance a WHERE a.customer_id = ?1 and a.employee_id = ?2 and a.time_out is null", nativeQuery = true)
  Attendance findByCustomerAndEmployee(long customerId, long employeeId);

}
