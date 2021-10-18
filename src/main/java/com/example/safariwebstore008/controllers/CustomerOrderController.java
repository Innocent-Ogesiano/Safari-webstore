package com.example.safariwebstore008.controllers;


import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.services.CustomerOrderServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasAuthority('CUSTOMER')")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderServices customerOrderServices;

    @GetMapping("/all")
    @ApiOperation(
            value = "Allows dispatch riders to view all deliveries",
            response = CustomerOrder.class)
    public ResponseEntity<List<CustomerOrder>> getAllDeliveries(
            @RequestParam(defaultValue="0") int pageNo,
            @RequestParam(defaultValue="5") int pageSize,
            @RequestParam(defaultValue="id") String sortBy) throws NoSuchFieldException {

        List<CustomerOrder> customerOrderList =  customerOrderServices.getAllDeliveries(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(customerOrderList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/pending")
    @ApiOperation(
            value = "Allows dispatch riders to view all pending deliveries",
            response = CustomerOrder.class)
    public ResponseEntity<List<CustomerOrder>> getAllPendingDeliveries(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
    List<CustomerOrder> customerPendingOrders = customerOrderServices.getAllPendingDeliveries(pageNo, pageSize, sortBy);
    return new ResponseEntity<>(customerPendingOrders, HttpStatus.ACCEPTED);
    }

    @GetMapping("/delivered")
    @ApiOperation(
            value = "Allows dispatch riders to view all deliveries that has been completed",
            response = CustomerOrder.class)
    public ResponseEntity<List<CustomerOrder>> getAllCompletedDeliveries(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        List<CustomerOrder> customerDelivered = customerOrderServices.getAllCompletedDeliveries(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(customerDelivered, HttpStatus.ACCEPTED);
    }
}
