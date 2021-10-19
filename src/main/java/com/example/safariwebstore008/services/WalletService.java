package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.dto.WithdrawalDto;
import com.example.safariwebstore008.exceptions.InsufficientFundsException;
import com.example.safariwebstore008.models.Wallet;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {
    Wallet topUpWalletAccount(FundWalletRequest fundWalletRequest);
    Double checkWalletBalance(String email);
    Wallet makePaymentByWallet(FundWalletRequest makePaymentDto) throws InsufficientFundsException;
    Wallet withdrawFromWallet(WithdrawalDto withdrawalDto, String email) throws InsufficientFundsException;
}
