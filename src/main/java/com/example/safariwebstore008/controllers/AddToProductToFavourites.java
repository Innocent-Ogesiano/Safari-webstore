package com.example.safariwebstore008.controllers;
import com.example.safariwebstore008.dto.ProductFavouritesDto;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.services.servicesImpl.FavouritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
@PreAuthorize("hasAuthority('CUSTOMER')")
@RestController
public class AddToProductToFavourites {
    @Autowired
   private  FavouritesServiceImpl favouritesService;
@PostMapping ("/add_favorite/{id}")

    public ResponseEntity<Object> addToFavourites(@PathVariable Long id,HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String userEmail = principal.getName();
        boolean message =  favouritesService.findFavouritesByProductsAndUserModel(userEmail,id);
        return new ResponseEntity<Object>(message,HttpStatus.OK);
    }
}
