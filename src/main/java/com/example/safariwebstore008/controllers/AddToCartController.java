package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.services.servicesImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddToCartController {
    @Autowired
    CartServiceImpl cartService;
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("/add_to_cart/{id}")
    public ResponseEntity<?> addToCart(@PathVariable Long id,HttpServletRequest req){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        cartService.addToCart(id,email);
        return  new ResponseEntity<Object>(HttpStatus.CREATED);
    }
}
