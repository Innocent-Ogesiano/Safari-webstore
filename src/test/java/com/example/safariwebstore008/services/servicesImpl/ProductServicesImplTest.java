package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        Product product1 = new Product();
        product1.setDescription("shirt");
        product1.setId(1L);
        Mockito.when(productRepository.getById(1L)).thenReturn(product1);
        Product product2= productServices.adminFetchParticularProduct(1l);

        Assertions.assertThat(product2.getDescription()).isEqualTo(product1.getDescription());

    }
}