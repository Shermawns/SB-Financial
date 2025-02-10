package com.main.S.B.Financial.controller.requests;

public record CreditCardRequest(
        Long userId,
        Long bank_account
) {}
