package com.example.safariwebstore008.services;

import com.example.safariwebstore008.models.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
}
