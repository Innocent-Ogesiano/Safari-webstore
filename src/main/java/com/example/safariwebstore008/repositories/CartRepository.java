package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart>findCartByUserModel(User user);
}
