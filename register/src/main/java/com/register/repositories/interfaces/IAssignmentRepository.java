package com.register.repositories.interfaces;

import java.util.List;

import com.register.models.Assignment;

public interface IAssignmentRepository {
  
  public Assignment save(Assignment Assignment);
  public Assignment update(Assignment Assignment);
  public void delete(int id);
  public List<Assignment> findAll();
  public Assignment findById(int id);


}
