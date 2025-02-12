package com.main.S.B.Financial.repositories;

import com.main.S.B.Financial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    UserDetails findByEmail(String login);

}
