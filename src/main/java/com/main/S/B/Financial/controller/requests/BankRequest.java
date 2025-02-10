package com.main.S.B.Financial.controller.requests;

import com.main.S.B.Financial.models.enums.AccountType;

public record BankRequest(
        Long userId,
        String agency,
        boolean active,
        AccountType accountType
) {}
