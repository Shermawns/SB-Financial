package com.main.S.B.Financial.services;

import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.repositories.BankAccountRepository;
import com.main.S.B.Financial.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(UserRepository userRepository, BankAccountRepository bankAccountRepository) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount save(BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
}
