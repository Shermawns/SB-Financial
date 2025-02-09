package com.main.S.B.Financial.controller;

import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/V1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User result = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
