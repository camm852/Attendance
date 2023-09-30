/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.register.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.register.models.Customer;
import com.register.repositories.interfaces.ICustomerRepository;

import java.util.List;

/**
 *
 * @author camm0
 */

@Service
@RequiredArgsConstructor
public class CustomerService{

    private final ICustomerRepository _customerRepository;
    
    public Customer save(Customer customer) {
        return _customerRepository.save(customer);
    }
    
    public List<Customer> findAll(){
        return _customerRepository.findAll();
    }
    
    public Customer findById(int id){
        return _customerRepository.findById(id);
    }
    
    public Customer update(Customer customer){
        return _customerRepository.update(customer);
    }
    
    public void delete(int id){
        _customerRepository.delete(id);
    }
}
