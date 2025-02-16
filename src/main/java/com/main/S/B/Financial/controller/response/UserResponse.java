package com.main.S.B.Financial.controller.response;

import com.main.S.B.Financial.models.Address;
import com.main.S.B.Financial.models.PixKey;

public record UserResponse(
        Long id,
        String name,
        Address address
) {
}
