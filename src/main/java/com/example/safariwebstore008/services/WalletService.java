package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.models.Wallet;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {
    Wallet topUpWalletAccount(FundWalletRequest fundWalletRequest);
    Double checkWalletBalance(String email);
}
