package com.main.S.B.Financial.controller;

import com.main.S.B.Financial.config.TokenService;
import com.main.S.B.Financial.controller.requests.LoginRequest;
import com.main.S.B.Financial.controller.response.LoginResponse;
import com.main.S.B.Financial.controller.response.UserResponse;
import com.main.S.B.Financial.mappers.UserMapper;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.repositories.UserRepository;
import com.main.S.B.Financial.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/V1/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UserController(UserService userService, UserMapper userMapper, UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponse> create(@Valid @RequestBody User user) {
        if (this.userRepository.findByEmail(user.getEmail()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User newUser = new User(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getAddress(),
                user.getEmail(),
                encryptedPassword,
                user.getBank_account(),
                user.getCreditCards(),
                user.getRole()
        );
        User saveUser = this.userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toResponse(saveUser));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }


    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(userMapper.toListResponse(list));
    }
}
