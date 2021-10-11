package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    private final WalletRepository walletRepository;

    @Autowired
    public UserServicesImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
    @Override
    public Double checkWalletBalance(String email) {
        Optional<Wallet> userWallet = walletRepository.findWalletByUserEmail(email);
        if (userWallet.isPresent()) {
            Wallet wallet = userWallet.get();
            return wallet.getWalletBalance();
        }
        return null;
    }
}
