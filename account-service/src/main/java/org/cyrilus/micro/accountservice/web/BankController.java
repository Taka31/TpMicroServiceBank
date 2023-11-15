package org.cyrilus.micro.accountservice.web;

import org.cyrilus.micro.accountservice.client.CustomerRestClient;
import org.cyrilus.micro.accountservice.entity.BankAccount;
import org.cyrilus.micro.accountservice.model.Customer;
import org.cyrilus.micro.accountservice.repository.BankRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankController {

    private final BankRepository myRepo;
    private final CustomerRestClient customerRestClient;


    public BankController(BankRepository myRepo, CustomerRestClient customerRestClient) {
        this.myRepo = myRepo;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping()
    public List<BankAccount> getBanks() {
        return myRepo.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getById(@PathVariable String id) {

        BankAccount account = myRepo.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
