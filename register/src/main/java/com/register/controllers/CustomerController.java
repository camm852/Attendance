package com.register.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping
    private ResponseEntity<String> save(Customer customer){
        _customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer saved");
    }

    @GetMapping
    private ResponseEntity<List<Customer>> findAll(){
        return  ResponseEntity.ok(_customerRepository.findAll());
    }

}
