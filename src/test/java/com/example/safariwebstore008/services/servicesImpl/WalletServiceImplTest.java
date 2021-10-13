package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.dto.MakePaymentDto;
import com.example.safariwebstore008.enums.TransactionType;
import com.example.safariwebstore008.exceptions.InsufficientFundsException;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.models.WalletTransaction;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.repositories.WalletTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
    void makePaymentByWallet() throws InsufficientFundsException {
        User user = new User();
        user.setEmail("johndoe@gmail.com");
        user.setId(1L);

        Date date = Date.valueOf(LocalDate.now());

        Wallet wallet = new Wallet();
        wallet.setWalletBalance(5000.00);
        wallet.setCreateDate(LocalDateTime.now());
        wallet.setUser(user);

        MakePaymentDto makePaymentDto = new MakePaymentDto(3000.00, Date.valueOf(LocalDate.now()), "johndoe@gmail.com");

        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setWallet(wallet);
        walletTransaction.setTransactionType(TransactionType.MAKEPAYMENT);
        walletTransaction.setAmount(makePaymentDto.getAmount());
        walletTransaction.setTransactionDate(date);

        Optional<Wallet> responseWallet = Optional.of(new Wallet());
        responseWallet.get().setWalletBalance(2000.00);
        responseWallet.get().setCreateDate(LocalDateTime.now());

        when(walletRepository.findWalletByUserEmail(makePaymentDto.getEmail())).thenReturn(Optional.of(wallet));
        when(walletTransactionRepository.save(walletTransaction)).thenReturn(walletTransaction);
        Wallet initialWallet = walletService.makePaymentByWallet(makePaymentDto);
        Assertions.assertThat(initialWallet.getWalletBalance()).isEqualTo(responseWallet.get().getWalletBalance());
        Assertions.assertThat(initialWallet.getWalletBalance()).isEqualTo(wallet.getWalletBalance());
    }

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


         when(userRepository.findUserByEmail(fundWalletRequest.getEmail())).thenReturn(user);
         when(walletRepository.save(wallet.get())).thenReturn(wallet.get());
         when(walletRepository.findWalletByUserEmail(fundWalletRequest.getEmail())).thenReturn(wallet);
         when(walletTransactionRepository.save(walletTransaction)).thenReturn(walletTransaction);
         Wallet wallet1= walletService.topUpWalletAccount(fundWalletRequest);





         Assertions.assertThat(wallet1.getWalletBalance()).isNotNull();
         Assertions.assertThat(wallet1.getWalletBalance()).isEqualTo(fundWalletRequest.getAmount());
     }

    @Test
    void checkWalletBalance() {
        String email = "inno@gmail.com";
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setWalletBalance(5000D);

        when(walletRepository.findWalletByUserEmail(email)).thenReturn(Optional.of(wallet));
        Double walletBalance = walletService.checkWalletBalance(email);
        System.out.println(walletBalance);
        assertEquals(walletBalance, wallet.getWalletBalance());
    }
}