package com.main.S.B.Financial.controller;

import com.main.S.B.Financial.controller.requests.PixRequest;
import com.main.S.B.Financial.controller.response.PixResponse;
import com.main.S.B.Financial.mappers.PixMapper;
import com.main.S.B.Financial.models.PixKey;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.services.PixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/V1/pix")
public class PixController {

    private final PixService pixService;
    private final PixMapper pixMapper;

    public PixController(PixService pixService, PixMapper pixMapper) {
        this.pixService = pixService;
        this.pixMapper = pixMapper;
    }

    @PostMapping(value = "/createKey")
    public ResponseEntity<PixResponse> create(@AuthenticationPrincipal User user, @RequestBody PixRequest pixRequest){

        PixKey pixKey = pixService.createPixKey(user.getId(), pixRequest.bankId(), pixRequest.pixType());

        return ResponseEntity.status(HttpStatus.CREATED).body(pixMapper.toResponse(pixKey));

    }

    @GetMapping("/viewKeys")
    public ResponseEntity<List<PixResponse>> getAllPixKeysByUserId(@AuthenticationPrincipal User user) {
        List<PixKey> pixKeys = pixService.findPixKeysByUserId(user.getId());


        if (pixKeys.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<PixResponse> pixResponseList = pixMapper.toListResponse(pixKeys);
        return ResponseEntity.ok().body(pixResponseList);
    }
}
