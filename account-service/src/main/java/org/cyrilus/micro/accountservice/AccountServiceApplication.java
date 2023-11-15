package org.cyrilus.micro.accountservice;

import org.cyrilus.micro.accountservice.entity.BankAccount;
import org.cyrilus.micro.accountservice.enums.AccountType;
import org.cyrilus.micro.accountservice.repository.BankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BankRepository repo) {

        return args -> {

            List<BankAccount> banks = List.of(
                    BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD").balance(9999.0)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(2L).build(),
                    BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(9999.0)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(1L).build());

            repo.saveAll(banks);
        };
    }

}
