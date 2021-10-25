package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.CartItem;
import com.example.safariwebstore008.repositories.CartIemRepository;
import com.example.safariwebstore008.repositories.CartRepository;
import com.example.safariwebstore008.services.DeleteCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DeleteCartSeviceImpl implements DeleteCartService {
    @Autowired
    private CartIemRepository cartIemRepository;
    @Autowired
  private  CartRepository cartRepository;
    @Override
    public void emptyCart(Cart cart) {
        cartIemRepository.deleteByCart_Id(cart.getId());
    }
}
