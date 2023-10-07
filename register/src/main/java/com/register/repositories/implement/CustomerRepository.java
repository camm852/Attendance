package com.register.repositories.implement;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.register.context.CustomerContext;
import com.register.models.Customer;
import com.register.repositories.interfaces.ICustomerRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements ICustomerRepository {

    private final CustomerContext _customerContext;


    @Override
    public Customer save(Customer customer) {
       return _customerContext.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Customer> findAll() {
        // TODO Auto-generated method stub
        return _customerContext.findAll();

    }

    @Override
    public Customer findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    

}
