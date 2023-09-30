package com.register.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.models.Customer;
import com.register.repositories.interfaces.ICustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    private final ICustomerRepository _customerRepository;

    @GetMapping
    private List<Customer> findAll(){
        return _customerRepository.findAll();
    }

}
