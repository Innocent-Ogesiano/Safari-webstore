package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.models.CustomerOrder;
import org.springframework.stereotype.Service;

@Service
public interface CustomerOrderService {
    CustomerOrder createACustomerOrder(CheckoutDto checkoutDto);
}
