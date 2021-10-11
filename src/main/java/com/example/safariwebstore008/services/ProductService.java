package com.example.safariwebstore008.services;

import com.example.safariwebstore008.models.Products;


import java.util.List;

public interface ProductService {
    List<Products> adminViewAllProductsPaginated(int page, int size);
    Products adminFetchParticularProduct(Long id);
}
