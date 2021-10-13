package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.configurations.JwtRequestFilter;
import com.example.safariwebstore008.configurations.JwtTokenUtil;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class UserController {
    UriComponentsBuilder uriComponentsBuilder;
    private final UserServices userServices;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserController(UserServices userServices, JwtTokenUtil jwtTokenUtil) {
        this.userServices = userServices;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/walletBalance")
    public ResponseEntity<Double> checkWalletBalance(HttpServletRequest request) throws ServletException, IOException {
        String token = request.getHeader("Authorization").split(" ")[1];
        String email = jwtTokenUtil.getUserEmailFromToken(token);
        Double walletBalance = userServices.checkWalletBalance(email);
        return new ResponseEntity<>(walletBalance, HttpStatus.OK);
    }
}
