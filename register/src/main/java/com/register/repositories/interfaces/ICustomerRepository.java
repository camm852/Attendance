package com.register.repositories.interfaces;

import java.util.List;

import com.register.models.Customer;

public interface ICustomerRepository {
  public Customer save(Customer customer);
  public Customer update(Customer customer);
  public void delete(int id);
  public List<Customer> findAll();
  public Customer findById(int id);
}
