package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.Customer;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

public interface CustomerServices {
    Customer updateCustomer(UpdateCustomerDto updateCustomerDto,String email) throws AccountNotFoundException;
}
