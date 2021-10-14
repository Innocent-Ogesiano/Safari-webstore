package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final UserServices userServices;

    @Autowired
    public CustomerController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PutMapping("/edit/{userEmail}")
    public ResponseEntity<User> editCustomer(@RequestBody UpdateCustomerDto editCustomerDto, @PathVariable("userEmail")String email) throws AccountNotFoundException {
        User users = userServices.updateCustomer(editCustomerDto,email);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

}
