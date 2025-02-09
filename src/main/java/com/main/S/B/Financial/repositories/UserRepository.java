package com.main.S.B.Financial.repositories;

import com.main.S.B.Financial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
