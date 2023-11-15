package org.cyrilus.micro.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.cyrilus.micro.accountservice.enums.AccountType;
import org.cyrilus.micro.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder @ToString
public class BankAccount {

    @Id
    private String accountId;
    private Double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
