package com.main.S.B.Financial.controller;

import com.main.S.B.Financial.controller.requests.BankRequest;
import com.main.S.B.Financial.controller.response.BankResponse;
import com.main.S.B.Financial.mappers.BankMapper;
import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.repositories.UserRepository;
import com.main.S.B.Financial.services.BankAccountService;
import com.main.S.B.Financial.utils.GenerateConfigs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "api/V1/bankAccount")
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final GenerateConfigs generateConfigs;
    private final UserRepository userRepository;
    private final BankMapper bankMapper;

    public BankAccountController(BankAccountService bankAccountService, GenerateConfigs generateConfigs, UserRepository userRepository, BankMapper bankMapper) {
        this.bankAccountService = bankAccountService;
        this.generateConfigs = generateConfigs;
        this.userRepository = userRepository;
        this.bankMapper = bankMapper;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BankResponse> create(@RequestBody BankRequest bankRequest) {

        BankAccount bankAccount = bankMapper.toDomain(bankRequest);

        User user = userRepository.findById(bankAccount.getUserId().getId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + bankAccount.getUserId().getId()));

        bankAccount.setAccount_number(generateConfigs.generateNumberAccount());

        bankAccount.setBalance(BigDecimal.valueOf(0));

        BankAccount result = bankAccountService.save(bankAccount);

        return ResponseEntity.status(HttpStatus.CREATED).body(bankMapper.toResponse(result));
    }

}
