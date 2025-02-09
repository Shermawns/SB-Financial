package com.main.S.B.Financial.services;

import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
