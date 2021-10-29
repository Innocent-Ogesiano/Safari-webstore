package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdateCartItemDto;
import com.example.safariwebstore008.models.CartItem;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.repositories.CartIemRepository;
import com.example.safariwebstore008.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UpdateCartItemServiceImplTest {
    @Mock
    CartIemRepository cartIemRepository;
    @InjectMocks
    UpdateCartItemServiceImpl servicesImpl;
    @BeforeEach
    void setUp() {
    }

    @Test
    void updateCartTest() {
        Product product = new Product();
        product.setId(1l);
        product.setProductName("versace");
        product.setPrice(BigInteger.valueOf(5000));
        product.setColor("red");
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(4);
        cartItem.setId(1l);
        UpdateCartItemDto updateCartItemDto = new UpdateCartItemDto();
        updateCartItemDto.setCartItemId(1l);
        updateCartItemDto.setItemQuanty(10);
        Mockito.when(cartIemRepository.findById(1l)).thenReturn(java.util.Optional.of((cartItem)));
        servicesImpl.updateCart(updateCartItemDto);

        assertEquals(updateCartItemDto.getItemQuanty(),10);
    }
}