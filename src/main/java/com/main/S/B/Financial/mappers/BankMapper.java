package com.main.S.B.Financial.mappers;

import com.main.S.B.Financial.controller.requests.BankRequest;
import com.main.S.B.Financial.controller.response.BankResponse;
import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public BankMapper(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public BankResponse toResponse(BankAccount bankAccount){
        return new BankResponse(
                bankAccount.getId(),
                userMapper.toResponse(bankAccount.getUserId()),
                bankAccount.getAccount_number(),
                bankAccount.getAgency(),
                bankAccount.getBalance(),
                bankAccount.isActive(),
                bankAccount.getAccountType()
        );
    }

    public BankAccount toDomain(BankRequest bankAccountRequest) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAgency(bankAccountRequest.agency());
        bankAccount.setAccountType(bankAccountRequest.accountType());

        return bankAccount;
    }
}
