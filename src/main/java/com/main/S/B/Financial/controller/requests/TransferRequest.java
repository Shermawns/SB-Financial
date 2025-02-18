package com.main.S.B.Financial.controller.requests;

import com.main.S.B.Financial.models.BankAccount;

import java.math.BigDecimal;

public record TransferRequest(String accountNumber,
                              BigDecimal amount,
                              String description) {
}
