package com.main.S.B.Financial.controller.response;

import com.main.S.B.Financial.models.enums.PixType;

import java.time.LocalDateTime;
import java.util.UUID;

public record PixResponse(
        String pixKey,
        PixType pixType,
        LocalDateTime createdAt
) {}

