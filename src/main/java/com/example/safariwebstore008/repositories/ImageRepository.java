package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ProductImages, Long> {

}
