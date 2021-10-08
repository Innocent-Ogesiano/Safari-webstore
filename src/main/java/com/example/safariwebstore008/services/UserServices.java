package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.User;

import javax.security.auth.login.AccountNotFoundException;

public interface UserServices {
    User updateCustomer(UpdateCustomerDto updateCustomerDto, String email) throws AccountNotFoundException;
}
