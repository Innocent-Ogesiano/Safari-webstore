package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.enums.TransactionType;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.models.WalletTransaction;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.repositories.WalletTransactionRepository;
import com.example.safariwebstore008.services.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class WalletServiceImplTest {
 @Mock
    private WalletRepository walletRepository;
 @Mock
    private WalletTransactionRepository walletTransactionRepository;
 @Mock
    private UserRepository userRepository;
 @InjectMocks
    private WalletServiceImpl walletService;

 @Test
 void fundWalletSuccessfully(){
     LocalDateTime localDateTime= LocalDateTime.now();

     Date date = Date.valueOf(LocalDate.now());

     Optional<Wallet> wallet = Optional.of(new Wallet());
     wallet.get().setWalletBalance(0.00);
     wallet.get().setCreateDate(localDateTime);


     FundWalletRequest fundWalletRequest= new FundWalletRequest();
     fundWalletRequest.setEmail("adababy@gmail.com");
     fundWalletRequest.setAmount(5000.00);
     fundWalletRequest.setTransactionDate(date);


     Optional<User> user = Optional.of(new User());
     user.get().setEmail("adababy@gmail.com");
     user.get().setId(1L);

     wallet.get().setUser(user.get());

     WalletTransaction walletTransaction= new WalletTransaction();
     walletTransaction.setWallet(wallet.get());
     walletTransaction.setAmount(fundWalletRequest.getAmount());
     walletTransaction.setTransactionDate(date);
    // walletTransaction.setUserModel(user.get());
     walletTransaction.setTransactionType(TransactionType.FUNDWALLET);


     Mockito.when(userRepository.findUserByEmail(fundWalletRequest.getEmail())).thenReturn(user);
     Mockito.when(walletRepository.save(wallet.get())).thenReturn(wallet.get());
     Mockito.when(walletRepository.findWalletByUserEmail(fundWalletRequest.getEmail())).thenReturn(wallet);
     Mockito.when(walletTransactionRepository.save(walletTransaction)).thenReturn(walletTransaction);
     Wallet wallet1= walletService.topUpWalletAccount(fundWalletRequest);





     Assertions.assertThat(wallet1.getWalletBalance()).isNotNull();
     Assertions.assertThat(wallet1.getWalletBalance()).isEqualTo(fundWalletRequest.getAmount());
 }

}