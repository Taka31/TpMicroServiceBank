package com.example.micro.customerservice;

import com.example.micro.customerservice.entity.Customer;
import com.example.micro.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repo) {
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder().firstName("Cyril").lastName("Menard")
                            .email("cyril@test.fr")
                            .build(),
                    Customer.builder().firstName("Natacha").lastName("Goldman")
                            .email("Natacha@test.fr")
                            .build());

			repo.saveAll(customerList);
        };
    }

}
