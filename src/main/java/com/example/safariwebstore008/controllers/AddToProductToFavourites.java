package com.example.safariwebstore008.controllers;
import com.example.safariwebstore008.dto.ProductFavouritesDto;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.services.servicesImpl.FavouritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class AddToProductToFavourites {
    @Autowired
    FavouritesServiceImpl favouritesService;
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping("/add_favorite")
    public ResponseEntity<Object> addToFavourites(@RequestBody ProductFavouritesDto productFavouritesDto, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String userEmail = principal.getName();
        String message =  favouritesService.findFavouritesByProductsAndUserModel(userEmail,productFavouritesDto);
        return new ResponseEntity<Object>(message,HttpStatus.OK);
    }
}
