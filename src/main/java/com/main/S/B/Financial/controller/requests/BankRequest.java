package com.main.S.B.Financial.controller.requests;

import com.main.S.B.Financial.models.enums.AccountType;

import java.math.BigDecimal;

public record BankRequest(
        Long userId,
        String accountNumber,
        String agency,
        BigDecimal balance,
        boolean active,
        AccountType accountType
) {}
