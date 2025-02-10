package com.main.S.B.Financial.controller.response;

import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.models.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreditCardResponse(
        Long id,
        UserResponse cardOwner,
        BankAccount bank_account,
        String card_number,
        LocalDate validate_date,
        Integer cvv,
        BigDecimal credit_limit,
        BigDecimal invoice,
        BigDecimal minimum_payment
) {}
