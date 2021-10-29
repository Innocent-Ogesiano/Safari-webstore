package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <ProductCategory, Long> {
    Optional<ProductCategory> findProductCategoryByProductCategoryName(String categoryName);
}
