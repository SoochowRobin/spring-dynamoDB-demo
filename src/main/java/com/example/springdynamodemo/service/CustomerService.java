package com.example.springdynamodemo.service;

import com.example.springdynamodemo.model.Customer;
import com.example.springdynamodemo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    final private CustomerRepository customerRepository;

    public String createCustomer(Customer customer){
        return customerRepository.createCustomer(customer);
    }

    public Customer updateCustomer(String id, Customer customer){
        return customerRepository.updateCustomer(id, customer);
    }

    public Customer getCustomer(String id){
        return customerRepository.getCustomerById(id);
    }

    public String deleteCustomer(String id){
        return customerRepository.deleteCustomer(id);
    }
}
