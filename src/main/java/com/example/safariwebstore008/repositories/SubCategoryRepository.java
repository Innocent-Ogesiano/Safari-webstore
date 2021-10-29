package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.ProductCategory;
import com.example.safariwebstore008.models.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
Optional<ProductSubCategory> findProductSubCategoryBySubCategoryName(String subCategoryName);
}
