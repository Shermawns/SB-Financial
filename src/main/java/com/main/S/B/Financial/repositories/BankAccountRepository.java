package com.main.S.B.Financial.repositories;

import com.main.S.B.Financial.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
