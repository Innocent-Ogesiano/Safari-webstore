package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.CartItem;
import com.example.safariwebstore008.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Repository
public interface CartIemRepository extends JpaRepository<CartItem,Long> {
Optional<CartItem> findCartItemByCartAndProduct(Cart cart, Product product);
 void deleteByCart_Id(Long id);
}
