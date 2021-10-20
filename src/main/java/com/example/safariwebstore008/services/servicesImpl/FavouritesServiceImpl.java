
package com.example.safariwebstore008.services.servicesImpl;
import com.example.safariwebstore008.dto.ProductFavouritesDto;
import com.example.safariwebstore008.models.Favourites;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.FavouriteRepository;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

    @Service
    public class FavouritesServiceImpl implements FavouriteService {
        @Autowired
        FavouriteRepository favouriteRepository;
        @Autowired
        ProductRepository productRepository;
        @Autowired
        UserRepository userRepository;
        @Override
        public String findFavouritesByProductsAndUserModel(String email, ProductFavouritesDto productFavouritesDto) {
            String message;
            User user = userRepository.findUserByEmail(email).get();
            System.out.println(user.getFirstName());
            String productColor = productFavouritesDto.getProductColor();
            String productName = productFavouritesDto.getProductName();

            Product product = productRepository.findProductsByColorsAndProductName(productColor,productName).get();
            System.out.println(product.getPrice());
            Optional<Favourites> optionalFavourites = favouriteRepository
                    .findFavouritesByProductsAndUserModel(product,user);
            if(optionalFavourites.isPresent()){
                favouriteRepository.delete(optionalFavourites.get());
                message = "Product remove from the list of user favourite";
                return message;
            }
            else{
                Favourites favourite = new Favourites();

                favourite.setProducts(new ArrayList<>(){{add(product);}});
                favourite.setUserModel(user);
                favouriteRepository.save(favourite);
                message = "Product added to the list of user favourites";
                return message;
            }
        }
    }
