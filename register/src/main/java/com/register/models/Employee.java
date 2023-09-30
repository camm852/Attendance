package com.register.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "employee_id")
  private long employeeId;

  @Column(name = "id")
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "photo")
  private String photo;
}
