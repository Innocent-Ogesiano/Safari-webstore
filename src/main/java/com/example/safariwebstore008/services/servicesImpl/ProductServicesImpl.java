package com.example.safariwebstore008.services.servicesImpl;
import com.example.safariwebstore008.models.Products;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Products> adminViewAllProductsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Products> productsPage = productRepository.findAll(pageable);
        return productsPage.toList();
    }

    @Override
    public Products adminFetchParticularProduct(Long id) {
        return productRepository.getById(id);
    }
}
