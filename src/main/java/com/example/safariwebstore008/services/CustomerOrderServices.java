package com.example.safariwebstore008.services;

import com.example.safariwebstore008.models.CustomerOrder;

import java.util.List;

public interface CustomerOrderServices {
    List<CustomerOrder> getAllDeliveries(int pageNo, int pageSize, String sortBy) throws NoSuchFieldException;
    List<CustomerOrder> getAllPendingDeliveries(int pageNo, int pageSize, String sortBy);
    List<CustomerOrder> getAllCompletedDeliveries(int pageNo, int pageSize, String sortBy);

}
