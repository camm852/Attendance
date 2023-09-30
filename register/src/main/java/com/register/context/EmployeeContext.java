package com.register.context;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.dtos.EmployeeDto;
import com.register.models.Employee;

public interface EmployeeContext extends JpaRepository<Employee, Long> {

  void save(EmployeeDto employeeDto);
  
}