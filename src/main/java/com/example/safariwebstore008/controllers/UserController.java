package com.example.safariwebstore008.controllers;


import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.services.servicesImpl.UserServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    @Autowired
    private final UserServicesImpl userServices;

    @PostMapping("/registercustomer")
    public User registerNewUser(@RequestBody RegistrationDto registrationDto) {
        return userServices.registerNewUser(registrationDto);
    }

    @PostMapping("/validate-registration-token/{tokenString}")
    public User validateRegistrationToken(@PathVariable("tokenString") String tokenString){
        return userServices.validateRegistrationToken(tokenString);
    }
}
