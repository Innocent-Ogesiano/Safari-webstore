package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.SafariWebstore008Application;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.repositories.ProductRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafariWebstore008Application.class)
class ProductServicesImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServicesImpl productServices;
    @Autowired
    ProductRepository repository;

    @Test
    void adminFetchParticularProduct() {
        Product product1 = new Product();
        product1.setDescription("shirt");
        product1.setId(1L);
        when(productRepository.getById(1L)).thenReturn(product1);
        Product product2= productServices.adminFetchParticularProduct(1l);
        assertThat(product2.getDescription()).isEqualTo(product1.getDescription());

    }

    @Test
    void searchProductsByKeyword() {
        Product product = new Product();
        product.setProductName("Wrist watch");
        product.setDescription("time piece for all ages");
        product.setPrice(5000D);
        repository.save(product);
        Product product1 = new Product();
        product1.setProductName("ankle watch");
        product1.setDescription("time piece for all ages");
        product1.setPrice(5000D);
        repository.save(product1);
        Product product2 = new Product();
        product2.setProductName("Shirt");
        product2.setDescription("time piece for all ages");
        product2.setPrice(5000D);
        repository.save(product2);
        List<Product> returnedList = repository.findProductsByProductNameContaining("watch");
        assertThat(returnedList.size()).isEqualTo(2);
        assertThat(returnedList).contains(product1);
        assertThat(returnedList).doesNotContain(product2);

    }
}