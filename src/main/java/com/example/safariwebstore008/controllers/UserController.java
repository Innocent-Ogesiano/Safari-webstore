package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.configurations.JwtRequestFilter;
import com.example.safariwebstore008.configurations.JwtTokenUtil;
import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.services.CustomerOrderService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class UserController {

    private CustomerOrderService customerOrderService;
    @Autowired
    public UserController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping("/checkout")
    private ResponseEntity<?> createACustomerOrder(@RequestBody CheckoutDto checkoutDto){
       CustomerOrder customerOrder=customerOrderService.createACustomerOrder(checkoutDto);
       if(customerOrder!=null){
       return new ResponseEntity<>(customerOrder,HttpStatus.CREATED);
       }else{
           return new ResponseEntity<>("User not allowed",HttpStatus.FORBIDDEN);
       }
    }
}
