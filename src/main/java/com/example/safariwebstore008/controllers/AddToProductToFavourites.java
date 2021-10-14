package com.example.safariwebstore008.controllers;
import com.example.safariwebstore008.dto.ProductFavouritesDto;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.services.servicesImpl.FavouritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class AddToProductToFavourites {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    FavouritesServiceImpl favouritesService;
@PostMapping("/add_favorite")
    public ResponseEntity<Object> addToFavourites(@RequestBody ProductFavouritesDto productFavouritesDto, HttpServletRequest request){
    Principal principal = request.getUserPrincipal();
   String color = productFavouritesDto.getProductColor();
    String userEmail = principal.getName();
    System.out.println(userEmail);
  String message =  favouritesService.findFavouritesByProductsAndUserModel(userEmail,productFavouritesDto);
  return new ResponseEntity<Object>(message,HttpStatus.OK);
}
}
