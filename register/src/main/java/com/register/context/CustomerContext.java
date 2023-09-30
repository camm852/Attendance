/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.register.context;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.models.Customer;

/**
 *
 * @author camm0
 */
public interface CustomerContext extends JpaRepository<Customer, Long> {
    List<Customer> findAll();
}
