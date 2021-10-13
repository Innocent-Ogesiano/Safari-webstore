package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MakePaymentDto;
import com.example.safariwebstore008.enums.TransactionType;
import com.example.safariwebstore008.exceptions.InsufficientFundsException;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.models.WalletTransaction;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.repositories.WalletTransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class WalletServiceImplTest {
    @Mock
    private WalletRepository walletRepository;
    @Mock
    private WalletTransactionRepository walletTransactionRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private WalletServiceImpl walletService;

    @Test
    public void makePaymentByWallet() throws InsufficientFundsException {
        User user = new User();
        user.setEmail("johndoe@gmail.com");
        user.setId(1L);

        Date date = Date.valueOf(LocalDate.now());

        Optional<Wallet> wallet = Optional.of(new Wallet());
        wallet.get().setWalletBalance(5000.00);
        wallet.get().setCreateDate(LocalDateTime.now());
        wallet.get().setUser(user);

        MakePaymentDto makePaymentDto = new MakePaymentDto(3000.00,Date.valueOf(LocalDate.now()),"johndoe@gmail.com");

        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setWallet(wallet.get());
        walletTransaction.setTransactionType(TransactionType.MAKEPAYMENT);
        walletTransaction.setAmount(makePaymentDto.getAmount());
        walletTransaction.setTransactionDate(date);

        Optional<Wallet> responseWallet = Optional.of(new Wallet());
        responseWallet.get().setWalletBalance(2000.00);
        responseWallet.get().setCreateDate(LocalDateTime.now());

        Mockito.when(walletRepository.save(wallet.get())).thenReturn(wallet.get());
        Mockito.when(walletRepository.findWalletByUserEmail(makePaymentDto.getEmail())).thenReturn(wallet);
        Mockito.when(walletTransactionRepository.save(walletTransaction)).thenReturn(walletTransaction);
        Wallet initialWallet = walletService.makePaymentByWallet(makePaymentDto);
        Assertions.assertThat(initialWallet.getWalletBalance()).isEqualTo(responseWallet.get().getWalletBalance());
    }

}