package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.MakePaymentDto;
import com.example.safariwebstore008.exceptions.InsufficientFundsException;
import com.example.safariwebstore008.models.Wallet;

public interface WalletService {
    Wallet makePaymentByWallet(MakePaymentDto makePaymentDto) throws InsufficientFundsException;
}
