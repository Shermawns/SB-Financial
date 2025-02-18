package com.main.S.B.Financial.controller.response;

import com.main.S.B.Financial.models.User;

import java.math.BigDecimal;

public record TransferResponse(
        String transactionId,
        BigDecimal amount,
        UserAccountInfo sender,
        UserAccountInfo recipient,
        String status,
        String message
) { }

