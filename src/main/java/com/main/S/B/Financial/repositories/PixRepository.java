package com.main.S.B.Financial.repositories;

import com.main.S.B.Financial.models.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PixRepository extends JpaRepository<PixKey, Long> {
    List<PixKey> findByUserId(Long userId);
}
