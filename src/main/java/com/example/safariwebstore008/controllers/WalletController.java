package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping("/wallet")
    public ResponseEntity<Wallet> fundWallet(@RequestBody FundWalletRequest fundWalletRequest){
        System.out.println(fundWalletRequest);
        Wallet wallet = walletService.topUpWalletAccount(fundWalletRequest);
        return new ResponseEntity<>(wallet,HttpStatus.OK);
    }


}
