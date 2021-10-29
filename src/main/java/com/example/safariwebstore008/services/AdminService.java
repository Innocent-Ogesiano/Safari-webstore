package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.ProductDto;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.ProductImages;
import com.example.safariwebstore008.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AdminService {

    User createDispatchRider (User dispatchRider);

    Product createProduct (ProductDto products);

    ProductImages saveToDB(String imageUrl, Long productId);

}
