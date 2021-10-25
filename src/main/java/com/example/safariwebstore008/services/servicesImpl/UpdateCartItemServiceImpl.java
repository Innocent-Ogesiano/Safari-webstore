package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdateCartItemDto;
import com.example.safariwebstore008.models.CartItem;
import com.example.safariwebstore008.repositories.CartIemRepository;
import com.example.safariwebstore008.repositories.CartRepository;
import com.example.safariwebstore008.services.UpdateCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCartItemServiceImpl implements UpdateCartItemService {
   @Autowired
   private   CartIemRepository cartIemRepository;
    @Override
    public void updateCart(UpdateCartItemDto updateCartItemDto) {
        Long cartId = updateCartItemDto.getCartItemId();
        int cartItemQuanty = updateCartItemDto.getItemQuanty();
        CartItem cartItem = cartIemRepository.findById(cartId).get();
        cartItem.setQuantity(cartItemQuanty);
        cartIemRepository.save(cartItem);
    }
}
