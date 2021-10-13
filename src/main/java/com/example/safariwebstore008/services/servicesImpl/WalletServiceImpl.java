package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.enums.TransactionType;
import com.example.safariwebstore008.exceptions.AccountNotEnabledException;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.models.WalletTransaction;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.repositories.WalletTransactionRepository;
import com.example.safariwebstore008.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private WalletTransactionRepository walletTransactionRepository;

    @Override
    public Wallet topUpWalletAccount(FundWalletRequest fundWalletRequest) {
        User user= userRepository.findUserByEmail(fundWalletRequest.getEmail()).get();
        System.out.println(user);
        if(user!=null){
            Optional<Wallet> wallet= walletRepository.findWalletByUserEmail(fundWalletRequest.getEmail());
            if(wallet.isPresent()){
                Double presentBalance= wallet.get().getWalletBalance();
                wallet.get().setWalletBalance(presentBalance + fundWalletRequest.getAmount());
                WalletTransaction walletTransaction = new WalletTransaction();
                walletTransaction.setTransactionDate(fundWalletRequest.getTransactionDate());
                walletTransaction.setTransactionType(TransactionType.FUNDWALLET);
                walletTransaction.setAmount(fundWalletRequest.getAmount());
                walletTransaction.setWallet(wallet.get());
                Wallet wallet4= walletRepository.save(wallet.get());
                walletTransactionRepository.save(walletTransaction);
                return wallet4;

            }
            else{
                Wallet wallet2 = new Wallet();
                wallet2.setUser(user);
                wallet2.setWalletBalance(fundWalletRequest.getAmount());
                WalletTransaction walletTransaction = new WalletTransaction();
                walletTransaction.setTransactionDate(fundWalletRequest.getTransactionDate());
                walletTransaction.setTransactionType(TransactionType.FUNDWALLET);
                walletTransaction.setAmount(fundWalletRequest.getAmount());
                walletTransaction.setWallet(wallet2);
                Wallet wallet3= walletRepository.save(wallet2);
                walletTransactionRepository.save(walletTransaction);
                return wallet3;
            }

        }
        else{
            throw new AccountNotEnabledException("User account not enabled");
        }
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
