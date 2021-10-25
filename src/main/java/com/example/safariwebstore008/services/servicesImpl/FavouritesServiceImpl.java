
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
import java.util.List;
import java.util.Optional;

    @Service
    public class FavouritesServiceImpl implements FavouriteService {
        @Autowired
       private FavouriteRepository favouriteRepository;
        @Autowired
       private ProductRepository productRepository;
        @Autowired
       private UserRepository userRepository;
        @Override
        public boolean findFavouritesByProductsAndUserModel(String email, Long id) {
            User user = userRepository.findUserByEmail(email).get();
            Product product = productRepository.findById(id).get();
            System.out.println(product.getPrice());
            Optional<Favourites> optionalFavourites = favouriteRepository
                    .findFavouritesByProductsAndUserModel(product,user);
            if(optionalFavourites.isPresent()){
                favouriteRepository.delete(optionalFavourites.get());
                return false;
            }
            else{
                Favourites favourite = new Favourites();

                favourite.setProducts(new ArrayList<>(){{add(product);}});
                favourite.setUserModel(user);
                favouriteRepository.save(favourite);
                return true;
            }
        }

        @Override
        public String findFavouritesByProductsAndUserModel(String email, ProductFavouritesDto productFavouritesDto) {
            return null;
        }

        @Override
        public Product viewProductFromFavourite(Long id, String email) {
            Product foundProduct = new Product();
             Favourites favourites = favouriteRepository.findFavouritesByUserModelEmail(email);
             List<Product> listOfProduct = favourites.getProducts();
             for (Product product : listOfProduct) {
                 if (product.getId() == id) {
                     foundProduct = product;
                 }
             }
             return foundProduct;
        }

        @Override
        public List<Product> viewAllProductFromFavourite(String email) {
            return favouriteRepository.findFavouritesByUserModelEmail(email).getProducts();
        }
    }
