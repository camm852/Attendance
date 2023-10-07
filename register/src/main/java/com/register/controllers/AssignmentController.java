package com.register.controllers;


import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping
  private ResponseEntity<String> save(Assignment assignment){
    _assignmentRepository.save(assignment);
    return ResponseEntity.status(HttpStatus.CREATED).body("Assignment saved");
  }

  @GetMapping
  private ResponseEntity<List<Assignment>> findAll(){
    return ResponseEntity.ok(_assignmentRepository.findAll());
  }

  



}
