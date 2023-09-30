package com.register.controllers;


import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.models.Assignment;
import com.register.repositories.interfaces.IAssignmentRepository;


@RestController
@RequestMapping("/api/v1/assignments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssignmentController {
  
  private final IAssignmentRepository _assignmentRepository;

  @GetMapping
  private List<Assignment> findAll(){
    return _assignmentRepository.findAll();
  }

  



}
