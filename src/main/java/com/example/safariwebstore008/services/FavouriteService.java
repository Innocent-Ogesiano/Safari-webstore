package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.ProductFavouritesDto;
import com.example.safariwebstore008.models.Products;
import com.example.safariwebstore008.models.User;
import org.springframework.stereotype.Service;

@Service
public interface FavouriteService {
    String findFavouritesByProductsAndUserModel(String email, ProductFavouritesDto productFavouritesDto);
}
