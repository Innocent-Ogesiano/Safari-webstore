package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products>findProductsByColorsAndProductName(String color,String productName);
//    Optional<Products>findByColorsAndProductName();
}
