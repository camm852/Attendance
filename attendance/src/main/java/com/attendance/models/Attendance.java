package com.attendance.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Timestamp;




@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendance")
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "attendance_id")
  private long attendaceId;

  @Column(name = "customer_id")
  private long customerId;

  @Column(name = "employee_id")
  private long employeeId;

  @Column(name = "timen_in")
  private Timestamp timeIn;

  @Column(name = "time_out")
  private Timestamp timeOut;

  @Column(name = "photo")
  private String photo;


}
