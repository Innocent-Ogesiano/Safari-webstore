
    package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.ProductFavouritesDto;

import org.springframework.stereotype.Service;

    @Service
    public interface FavouriteService {
        String findFavouritesByProductsAndUserModel(String email, ProductFavouritesDto productFavouritesDto);
    }
