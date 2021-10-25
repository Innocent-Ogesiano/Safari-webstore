package com.example.safariwebstore008.controllers;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> viewAllProducts(@RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
                                                         @RequestParam (value = "pageSize", required = false, defaultValue = "4") int pageSize){
        List<Product> response = productService.adminViewAllProductsPaginated(pageNo,pageSize);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> viewASingleProduct(@PathVariable(value = "productId") Long productId){
        Product product = productService.adminFetchParticularProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/searchProduct")
    public ResponseEntity<?> searchProductByKeyword(@RequestParam String keyword) {
        List<Product> productList = productService.searchProductsByKeyword(keyword);
        if (productList.size() == 0) {
            return ResponseEntity.ok("No matching product found");
        }
        return ResponseEntity.ok(productList);
    }
}
