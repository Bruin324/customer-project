package com.example.customer.service;

import com.example.customer.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer customer);
    Customer getById(int id);
    List<Customer> get();
    void update(Customer customer);
    void delete(int id);
}
