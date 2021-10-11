package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.repositories.WalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class UserServicesImplTest {
    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private UserServicesImpl userServices;

    @Test
    void checkWalletBalance() {
        String email= "inno@gmail.com";
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setWalletBalance(5000D);

        when(walletRepository.findWalletByUserEmail(email)).thenReturn(Optional.of(wallet));
        Double walletBalance = userServices.checkWalletBalance(email);
        System.out.println(walletBalance);
        Assertions.assertEquals(walletBalance, wallet.getWalletBalance());
    }
}