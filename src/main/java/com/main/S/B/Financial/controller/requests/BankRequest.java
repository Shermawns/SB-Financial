package com.main.S.B.Financial.controller.requests;

import com.main.S.B.Financial.models.enums.AccountType;

public record BankRequest(
        String agency,
        AccountType accountType
) {}
