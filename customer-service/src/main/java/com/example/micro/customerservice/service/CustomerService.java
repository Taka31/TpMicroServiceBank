package com.example.micro.customerservice.service;

import com.example.micro.customerservice.entity.Customer;
import com.example.micro.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository myRepo;

    public CustomerService(CustomerRepository myRepo) {
        this.myRepo = myRepo;
    }

    public List<Customer> getCustomers(){
        return myRepo.findAll();
    }

    public Customer findById(Long id) {
        return myRepo.findById(id).stream().findFirst().orElse(null);
    }
}
