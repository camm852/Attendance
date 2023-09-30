package com.register.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.register.models.Assignment;
import com.register.repositories.interfaces.IAssignmentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AssignmentService {
  
  private final IAssignmentRepository _assignmentRepository;

  public void save(Assignment assignment) {
      _assignmentRepository.save(assignment);
  }

  public List<Assignment> findAll(){
    return _assignmentRepository.findAll();
  }



}
