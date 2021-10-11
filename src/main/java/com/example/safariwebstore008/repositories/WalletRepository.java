package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findWalletByUserId(Long userId);
    Optional<Wallet> findWalletByUserEmail(String email);
}
