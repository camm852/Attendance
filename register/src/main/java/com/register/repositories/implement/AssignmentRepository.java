package com.register.repositories.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.register.context.AssignmentContext;
import com.register.models.Assignment;
import com.register.repositories.interfaces.IAssignmentRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AssignmentRepository implements IAssignmentRepository{
  
  private final AssignmentContext _assignmentContext;


  public Assignment save(Assignment assignment) {
    return _assignmentContext.save(assignment);
  }

  @Override
  public Assignment update(Assignment Assignment) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }


  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }


  @Override
  public List<Assignment> findAll() {
    return _assignmentContext.findAll();
  }


  @Override
  public Assignment findById(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }



}
