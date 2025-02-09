package com.main.S.B.Financial.controller;

import com.main.S.B.Financial.controller.response.UserResponse;
import com.main.S.B.Financial.mappers.UserMapper;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/V1/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponse> register(@RequestBody User user){

        User result = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(userMapper.toListResponse(list));
    }
}
