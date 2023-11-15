package org.cyrilus.micro.accountservice.repository;

import org.cyrilus.micro.accountservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankAccount,String> {
}
