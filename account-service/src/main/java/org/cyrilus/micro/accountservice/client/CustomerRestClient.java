package org.cyrilus.micro.accountservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.cyrilus.micro.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService",fallbackMethod="getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name="customerService",fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder()
                .id(id)
                .firstName("plante")
                .lastName("service")
                .email("out")
                .build();
    }

    default List<Customer> getAllCustomers(Exception e){
        return List.of();
    }
}
