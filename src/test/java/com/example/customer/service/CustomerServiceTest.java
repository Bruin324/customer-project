package com.example.customer.service;

import com.example.customer.domain.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Inigo");
        customer1.setLastName("Montoya");
        customer1.setEmail("inconceivable@princess-bride.com");
        customer1.setPhone("843-555-1010");

        customerService.add(customer1);

        List<Customer> customers = customerService.get();

        Assert.assertFalse(customers.isEmpty());
    }

}
