package com.register.context;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.models.Assignment;

public interface AssignmentContext extends JpaRepository<Assignment, Long> {
  
  


}
