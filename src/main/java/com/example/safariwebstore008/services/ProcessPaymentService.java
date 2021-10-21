package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.dto.ProcessPaymentDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface ProcessPaymentService {
    ProcessPaymentDTO processPayment(CheckoutDto checkoutDto);
}
