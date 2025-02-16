package com.main.S.B.Financial.controller.requests;

import com.main.S.B.Financial.models.enums.PixType;

public record PixRequest(Long bankId,
                         PixType pixType){
}
