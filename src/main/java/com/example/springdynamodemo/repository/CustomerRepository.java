package com.example.springdynamodemo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.springdynamodemo.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    final private DynamoDBMapper dynamoDBMapper;

    public String createCustomer(Customer customer){
        dynamoDBMapper.save(customer);
        return customer.getId();
    }

    public Customer getCustomerById(String id){
        return dynamoDBMapper.load(Customer.class, id);
    }

    public Customer updateCustomer(String id, Customer customer){
        Customer load = dynamoDBMapper.load(Customer.class, id);
        // map these two entity
        load.setName(customer.getName());
        load.setAge(customer.getAge());
        load.setDob(customer.getDob());
        load.setContactList(customer.getContactList());
        load.setActiveFlag(customer.getActiveFlag());
        dynamoDBMapper.save(load);

        return dynamoDBMapper.load(Customer.class, id);
    }

    public String deleteCustomer(String id){
        Customer load = dynamoDBMapper.load(Customer.class, id);
        dynamoDBMapper.delete(load);
        return load.getId() + " get deleted !";
    }
}
