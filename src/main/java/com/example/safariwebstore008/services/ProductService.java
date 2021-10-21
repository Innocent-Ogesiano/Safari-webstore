package com.example.safariwebstore008.services;

import com.example.safariwebstore008.models.Product;


import java.util.List;

public interface ProductService {
    List<Product> adminViewAllProductsPaginated(int page, int size);
    Product adminFetchParticularProduct(Long id);
    List<Product> searchProductsByKeyword(String keyword);
}
