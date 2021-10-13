package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.MakePaymentDto;
import com.example.safariwebstore008.exceptions.InsufficientFundsException;
import com.example.safariwebstore008.configurations.JwtTokenUtil;
import com.example.safariwebstore008.dto.FundWalletRequest;
import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class WalletController {

    @Autowired
    private WalletService walletService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/walletPayment")
    public ResponseEntity<Wallet> makePaymentByWallet(@RequestBody MakePaymentDto makePaymentDto) throws InsufficientFundsException {
        Wallet wallet = walletService.makePaymentByWallet(makePaymentDto);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }
    
    @PostMapping("/wallet")
    public ResponseEntity<Wallet> fundWallet(@RequestBody FundWalletRequest fundWalletRequest){
        System.out.println(fundWalletRequest);
        Wallet wallet = walletService.topUpWalletAccount(fundWalletRequest);
        return new ResponseEntity<>(wallet,HttpStatus.OK);
    }

    @GetMapping("/walletBalance")
    public ResponseEntity<Double> checkWalletBalance(HttpServletRequest request) throws ServletException, IOException {
        String token = request.getHeader("Authorization").split(" ")[1];
        String email = jwtTokenUtil.getUserEmailFromToken(token);
        Double walletBalance = walletService.checkWalletBalance(email);
        return new ResponseEntity<>(walletBalance, HttpStatus.OK);
    }

}
