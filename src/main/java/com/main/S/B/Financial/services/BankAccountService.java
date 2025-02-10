package com.main.S.B.Financial.services;

import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount save(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }

    public Optional<BankAccount> findById(Long id) {
        return bankAccountRepository.findById(id);
    }
}

