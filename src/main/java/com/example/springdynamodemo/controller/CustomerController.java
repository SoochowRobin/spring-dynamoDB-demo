package com.example.springdynamodemo.controller;

import com.example.springdynamodemo.model.Customer;
import com.example.springdynamodemo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CustomerController {

    final private CustomerService customerService;

    @PostMapping("/customer")
    public String createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }


    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }
}
