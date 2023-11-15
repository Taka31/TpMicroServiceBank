package com.example.micro.customerservice.web;

import com.example.micro.customerservice.entity.Customer;
import com.example.micro.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService myService;


    public CustomerController(CustomerService myService) {
        this.myService = myService;
    }

    @GetMapping
    public List<Customer> getCustomerList() {
        return myService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return myService.findById(id);
    }
}
