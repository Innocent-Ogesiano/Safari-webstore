
package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Favourites;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
    @Repository
    public interface FavouriteRepository extends JpaRepository<Favourites,Long> {
        Optional<Favourites> findFavouritesByProductsAndUserModel(Product product, User user);
        Favourites findFavouritesByUserModelEmail(String email);

    }
