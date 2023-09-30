package com.register.repositories.interfaces;

import java.util.List;

import com.register.dtos.EmployeeDto;
import com.register.models.Employee;

public interface IEmployeeRepository {
  
  public Employee save(EmployeeDto employeeDto);
  public Employee update(EmployeeDto employeeDto);
  public void delete(int id);
  public List<Employee> findAll();
  public Employee findById(int id);

}
