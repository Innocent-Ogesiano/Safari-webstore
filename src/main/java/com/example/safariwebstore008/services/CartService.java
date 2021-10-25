package com.example.safariwebstore008.services;

import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.User;

import java.util.Optional;

public interface CartService {
 Cart findById(Long id);
 void addToCart(Long productId,String userEmail);
 Optional<Cart>findCartByUser(User user);
}
