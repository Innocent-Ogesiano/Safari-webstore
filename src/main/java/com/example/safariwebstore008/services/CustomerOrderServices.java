package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.models.CustomerOrder;

import java.util.List;

public interface CustomerOrderServices {
    List<CustomerOrder> getAllDeliveries(int pageNo, int pageSize, String sortBy) throws NoSuchFieldException;
    List<CustomerOrder> getAllPendingDeliveries(int pageNo, int pageSize, String sortBy);
    List<CustomerOrder> getAllCompletedDeliveries(int pageNo, int pageSize, String sortBy);
    CustomerOrder createACustomerOrder(CheckoutDto checkoutDto);
    List<CustomerOrder> viewCustomerOrderHistory(String userEmail, int pageSize, int pageNo,String sortBy);

}
