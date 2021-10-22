package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Favourites;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.FavouriteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FavouritesServiceImplTest {

    @Mock
    private FavouriteRepository favouriteRepository;

    @InjectMocks
    private FavouritesServiceImpl favouritesService;

    @Test
    void viewProductFromFavourite() {
        User user = new User();
        user.setEmail("johndoe@gmail.com");

        Product product = new Product();
        product.setId(1L);
        product.setProductName("Timberland Shoe");

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        Favourites favourites = new Favourites();
        favourites.setUserModel(user);
        favourites.setProducts(productList);

        when(favouriteRepository.findFavouritesByUserModelEmail(user.getEmail())).thenReturn(favourites);
        Product responseProduct = favouritesService.viewProductFromFavourite(product.getId(), user.getEmail());
        Assertions.assertThat(product.getProductName()).isEqualTo(responseProduct.getProductName());
    }

    @Test
    void viewAllProductFromFavourite() {
        User user = new User();
        user.setEmail("johndoe@gmail.com");

        Product product = new Product();
        product.setId(1L);
        product.setProductName("Timberland Shoe");

        Product product2 = new Product();
        product.setId(2L);
        product.setProductName("Tommy Shirt");

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        Favourites favourites = new Favourites();
        favourites.setUserModel(user);
        favourites.setProducts(productList);

        when(favouriteRepository.findFavouritesByUserModelEmail(user.getEmail())).thenReturn(favourites);
        List<Product> responseListOfProduct = favouritesService.viewAllProductFromFavourite(user.getEmail());
        Assertions.assertThat(favourites.getProducts().size()).isEqualTo(responseListOfProduct.size());
    }
}