package com.main.S.B.Financial.controller.response;
import com.main.S.B.Financial.models.enums.AccountType;

import java.math.BigDecimal;

public record BankResponse(
        Long bankId,
        UserResponse owner,
        String accountNumber,
        String agency,
        BigDecimal balance,
        boolean active,
        AccountType accountType
){
}
