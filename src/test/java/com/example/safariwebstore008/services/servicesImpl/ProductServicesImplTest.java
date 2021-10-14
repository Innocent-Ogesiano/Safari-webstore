package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Products;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServicesImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServicesImpl productServices;

    @Test
    void adminFetchParticularProduct() {
        Products products1= new Products();
        products1.setDescription("shirt");
        products1.setId(1L);
        Mockito.when(productRepository.getById(1L)).thenReturn(products1);
        Products product2= productServices.adminFetchParticularProduct(1l);

        Assertions.assertThat(product2.getDescription()).isEqualTo(products1.getDescription());

    }
}