package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.CartItem;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.CartIemRepository;
import com.example.safariwebstore008.repositories.CartRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartIemRepository cartIemRepository;
    @Autowired
   private CartRepository cartRepository;
    @Autowired
   private UserRepository userRepository;
    @Override
    public void removeItemFromCart(Long id,String email) {
        User user = userRepository.findUserByEmail(email).get();
        Cart cart = cartRepository.findCartByUserModel(user).get();
        List<CartItem>cartItems = cart.getCartItemList();

        CartItem cartItem = new CartItem();
        for (CartItem item : cartItems) {
            if(item.getId().equals(id)){
              cartItem =item;
            }
        }
        cartItems.remove(cartItem);
        cartIemRepository.delete(cartItem);

    }
}
