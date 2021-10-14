package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.ProductFavouritesDto;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.models.Favourites;
import com.example.safariwebstore008.models.Products;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.FavouriteRepository;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FavouritesServiceImplTest {
@Mock
    FavouriteRepository favouriteRepository;
    @Mock
    ProductRepository productRepository;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    FavouritesServiceImpl favouritesService;
    @BeforeEach
    void setUp() {
    }
    @Test
    public  void favouritesServiceImplTestRemoveFromFavorite(){
        User user  = new User();
        user.setEmail("bunmi@gmail.com");
        user.setPassword("1234");
        user.setFirstName("bunmi");
        user.setGender(Gender.FEMALE);
        user.setLastName("ofunrein");
        Products products = new Products();
        products.setProductName("versace");
        products.setColors("red");
        Favourites favourites = new Favourites();
        favourites.setUserModel(user);
        favourites.setProducts(new ArrayList<>(){{add(products);}});
        ProductFavouritesDto productFavouritesDto = new ProductFavouritesDto("versace","red");

        Mockito.when(userRepository.findUserByEmail(any())).thenReturn(java.util.Optional.of(user));
        Mockito.when(productRepository.findByColorsAndProductName(any(),any())).thenReturn(java.util.Optional.of(products));
        Mockito.when(favouriteRepository.findFavouritesByProductsAndUserModel(any(),any())).thenReturn(java.util.Optional.of(favourites));
       String message = favouritesService.findFavouritesByProductsAndUserModel("bunmi@gmail.com",productFavouritesDto);
        Assertions.assertThat(message).isEqualTo("Product remove from the list of user favourite");
    }

}