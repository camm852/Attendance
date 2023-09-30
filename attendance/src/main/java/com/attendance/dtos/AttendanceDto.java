package com.attendance.dtos;

import java.sql.Timestamp;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttendanceDto {
  private long customerId;
  private long employeeId;
  private Timestamp timeIn;
  private Timestamp timeOut;
  private String photo;
}
