package com.register.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

  private String id;
  private String name;
  private String photo;
  private long customerId;

}