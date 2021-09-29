package com.example.safariwebstore008.controllers;


import com.example.safariwebstore008.services.servicesImpl.UserServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    @Autowired
    private final UserServicesImpl userServices;
}
