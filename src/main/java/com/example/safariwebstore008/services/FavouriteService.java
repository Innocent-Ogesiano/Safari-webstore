
    package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.ProductFavouritesDto;

import com.example.safariwebstore008.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public interface FavouriteService {
       boolean findFavouritesByProductsAndUserModel(String email, Long id);
        String findFavouritesByProductsAndUserModel(String email, ProductFavouritesDto productFavouritesDto);
        Product viewProductFromFavourite(Long id, String email);
        List<Product> viewAllProductFromFavourite(String email);
    }
