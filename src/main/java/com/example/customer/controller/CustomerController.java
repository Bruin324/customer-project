package com.example.customer.controller;

import com.example.customer.domain.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customers")
    String customers(Model model) {
        model.addAttribute("customers", customerService.get());
        return "customers";
    }

    @RequestMapping("/add-customer")
    public String addCustomers(Model model) {
        return "add-customer";
    }

    @RequestMapping("/create-customer")
    public String createCustomer(@RequestParam(value="first_name") String firstName, @RequestParam(value="last_name") String lastName, @RequestParam(value="phone") String phone, @RequestParam(value="email") String email, Model model) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);

        customerService.add(customer);

        return "redirect:/customers";
    }

    @RequestMapping("/view-customer/{customerId}")
    public String viewCustomer(@PathVariable int customerId, Model model) {
        model.addAttribute("customer", customerService.getById(customerId));
        return "view-customer";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/loggedout")
    String logout(Model model) {
        List<Customer> persons = customerService.get();
        model.addAttribute("listOPeople", persons);
        return "redirect:/customers";
    }

    @GetMapping("/admins-only")
    String admins() {
        return "administration";
    }
}