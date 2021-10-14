package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.User;

import javax.security.auth.login.AccountNotFoundException;

import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    User updateCustomer(UpdateCustomerDto updateCustomerDto, String email) throws AccountNotFoundException;

    User signup(RegistrationDto registrationDto);
    User updatePassword(UpdatePasswordDto passwordRestDto, String email) throws Exception;
}
