package com.example.safariwebstore008.controllers;


import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.ProductPage;
import com.example.safariwebstore008.models.ProductSearchCriteria;
import com.example.safariwebstore008.services.servicesImpl.ProductFilterServiceimpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myProducts")
public class ProductFilterController {
    private final ProductFilterServiceimpl myProductService;

    public ProductFilterController(ProductFilterServiceimpl myProductService) {
        this.myProductService = myProductService;
    }
    @GetMapping("/filterAndSortProducts")
    public ResponseEntity<Page<Product>> getMyProducts(ProductPage myProductPage,
                                                       ProductSearchCriteria myProductSearchCriteria){
        return new ResponseEntity<>(myProductService.getProducts(myProductPage,
                myProductSearchCriteria), HttpStatus.OK);
    }
}
