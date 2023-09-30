package com.register.repositories.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import com.register.context.EmployeeContext;
import com.register.dtos.EmployeeDto;
import com.register.models.Employee;
import com.register.models.Assignment;
import com.register.repositories.interfaces.IAssignmentRepository;
import com.register.repositories.interfaces.IEmployeeRepository;



import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository implements IEmployeeRepository{

  private final EmployeeContext _employeeContext;
  private final IAssignmentRepository _assignmentRepository;
  
  public Employee save(EmployeeDto employeeDto) {
    Employee employee = _employeeContext.save(new Employee(0, employeeDto.getId(), 
    employeeDto.getName(), ""));
    
    _assignmentRepository.save(new Assignment(0, employeeDto.getCustomerId(), 
      employee.getEmployeeId(),new Timestamp(System.currentTimeMillis()),null));

    return employee;
  }

  @Override
  public Employee update(EmployeeDto employeeDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public List<Employee> findAll() {
        return _employeeContext.findAll();
  }

  @Override
  public Employee findById(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

}
