package com.main.S.B.Financial.mappers;

import com.main.S.B.Financial.controller.response.PixResponse;
import com.main.S.B.Financial.models.PixKey;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PixMapper {

    public PixResponse toResponse(PixKey pixKey){
        return new PixResponse(
                pixKey.getKey(),
                pixKey.getPixType(),
                pixKey.getCreatedAt()
        );
    }

    public List<PixResponse> toListResponse(List<PixKey> pixKeys) {
        return pixKeys.stream()
                .map(pixKey -> new PixResponse(
                        pixKey.getKey(),
                        pixKey.getPixType(),
                        pixKey.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

}
