package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.dto.WithdrawalDto;
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

import java.sql.Date;
import java.time.LocalDate;
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
    public Wallet makePaymentByWallet(FundWalletRequest makePaymentDto) throws InsufficientFundsException {
        Optional<Wallet> optionalWallet = walletRepository.findWalletByUserEmail(makePaymentDto.getEmail());
        Wallet wallet = optionalWallet.get();
        Double walletBalance = wallet.getWalletBalance();
        Double costOfProduct = makePaymentDto.getAmount();
        if (walletBalance > costOfProduct) {
            Double newWalletBalance = walletBalance - costOfProduct;
            wallet.setWalletBalance(newWalletBalance);
            walletRepository.save(wallet);
            WalletTransaction walletTransaction = new WalletTransaction();
            walletTransaction.setTransactionDate(makePaymentDto.getTransactionDate());
            walletTransaction.setTransactionType(TransactionType.MAKEPAYMENT);
            walletTransaction.setAmount(makePaymentDto.getAmount());
            walletTransaction.setWallet(wallet);
            walletTransactionRepository.save(walletTransaction);
            return wallet;
        } else {
            throw new InsufficientFundsException("Your wallet balance is not sufficient to buy product, kindly fund your wallet");
        }
    }

    @Override
    public Wallet withdrawFromWallet(WithdrawalDto withdrawalDto, String email) throws InsufficientFundsException {
        Wallet wallet = walletRepository.findWalletByUserEmail(email).get();
        if(wallet.getWalletBalance() > withdrawalDto.getAmount()){
            Double balance = wallet.getWalletBalance() - withdrawalDto.getAmount();
            wallet.setWalletBalance(balance);
            walletRepository.save(wallet);
            WalletTransaction walletTransaction = new WalletTransaction();
            walletTransaction.setTransactionType(TransactionType.WITHDRAWAL);
            walletTransaction.setTransactionDate(Date.valueOf(LocalDate.now()));
            walletTransaction.setAmount(withdrawalDto.getAmount());
            walletTransaction.setWallet(wallet);
            walletTransactionRepository.save(walletTransaction);
        }else {
            throw new InsufficientFundsException("insufficient Fund");
        }
        return wallet;
    }


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
