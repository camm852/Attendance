package com.register.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.register.dtos.EmployeeDto;
import com.register.models.Employee;
import com.register.repositories.interfaces.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final IEmployeeRepository _employeeRepository;

  public Employee save(EmployeeDto employeeDto) {
    return _employeeRepository.save(employeeDto);
  }

  public List<Employee> findAll(){
    return _employeeRepository.findAll();
  }

}