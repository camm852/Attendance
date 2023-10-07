package com.register.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.dtos.EmployeeDto;
import com.register.models.Employee;
import com.register.repositories.interfaces.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees") 
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

  private final IEmployeeRepository _employeeRepository;

  @PostMapping
  public ResponseEntity<Employee> save(@RequestBody EmployeeDto employeeDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(_employeeRepository.save(employeeDto));
  }

  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees(){
    return ResponseEntity.ok(_employeeRepository.findAll());
  }

}
