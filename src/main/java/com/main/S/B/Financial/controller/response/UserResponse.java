package com.main.S.B.Financial.controller.response;

import com.main.S.B.Financial.models.Address;

public record UserResponse(
        String name,
        String email,
        Address address
) {
}
