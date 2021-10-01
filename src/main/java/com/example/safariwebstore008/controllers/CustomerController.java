package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.Customer;
import com.example.safariwebstore008.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @PutMapping("/edit/{userEmail}")
    public ResponseEntity<Customer> editCustomer(@RequestBody UpdateCustomerDto editCustomerDto, @PathVariable("userEmail")String email) throws AccountNotFoundException {
        Customer customer = customerServices.updateCustomer(editCustomerDto,email);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

}
