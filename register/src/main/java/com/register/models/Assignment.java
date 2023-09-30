package com.register.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignments")
public class Assignment {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "assignment_id")
  private long assignmentId;


  @Column(name = "customer_id")
  private long customerId;

  @Column(name = "employee_id")
  private long employeeId;

  @Column(name = "start_date")
  private Timestamp startDate = new Timestamp(System.currentTimeMillis());
  
  @Column(name = "end_date")
  private Timestamp endDate = null;


}
