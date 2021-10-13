package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MakePaymentDto;
import com.example.safariwebstore008.enums.TransactionType;
import com.example.safariwebstore008.exceptions.AccountNotEnabledException;
import com.example.safariwebstore008.exceptions.InsufficientFundsException;
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
    UserRepository userRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    WalletTransactionRepository walletTransactionRepository;

    @Override
    public Wallet makePaymentByWallet(MakePaymentDto makePaymentDto) throws InsufficientFundsException {
            Optional<Wallet> optionalWallet = walletRepository.findWalletByUserEmail(makePaymentDto.getEmail());
                Wallet wallet = optionalWallet.get();
                Double walletBalance = wallet.getWalletBalance();
                Double costOfProduct = makePaymentDto.getAmount();
                if (walletBalance > costOfProduct) {
                    Double newWalletBalance = walletBalance - costOfProduct;
                    wallet.setWalletBalance(newWalletBalance);
                    WalletTransaction walletTransaction = new WalletTransaction();
                    walletTransaction.setTransactionDate(makePaymentDto.getTransactionDate());
                    walletTransaction.setTransactionType(TransactionType.MAKEPAYMENT);
                    walletTransaction.setAmount(makePaymentDto.getAmount());
                    walletTransaction.setWallet(wallet);
                    walletTransactionRepository.save(walletTransaction);
                    return walletRepository.save(wallet);
                } else {
                    throw new InsufficientFundsException("Your wallet balance is not sufficient to buy product, kindly fund your wallet");
                }
        }
    }




