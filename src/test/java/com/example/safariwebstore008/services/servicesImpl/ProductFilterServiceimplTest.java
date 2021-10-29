package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.SafariWebstore008Application;
import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.ProductPage;
import com.example.safariwebstore008.models.ProductSearchCriteria;
import com.example.safariwebstore008.repositories.ProductFilterCriteriaRepository;
import com.example.safariwebstore008.repositories.ProductFilterRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafariWebstore008Application.class)
@ExtendWith(MockitoExtension.class)
class ProductFilterServiceimplTest {
    @Mock
    ProductFilterCriteriaRepository productFilterCriteriaRepository;
    @InjectMocks
    ProductFilterServiceimpl productFilterServiceimpl;
    @BeforeEach
    void setUp() {

    }

    @Test
    void getProductsBySearchCriteria() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("necklace");
        product.setPrice(BigInteger.valueOf(300));
        product.setDescription("for the young and old");
        product.setColor("blue");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        final Page<Product> page = new PageImpl<>(productList);
        ProductPage productPage = new ProductPage(0, 10, Sort.Direction.ASC, "id");
        ProductSearchCriteria productSearchCriteria = new ProductSearchCriteria("blue", "shoes",
                "medium", "300");

            when(productFilterCriteriaRepository.findAllProductWithFilter(any(),any()))
                    .thenReturn((page));
             productFilterServiceimpl.getProducts(productPage, productSearchCriteria);

        assertEquals(page.getTotalElements(), productFilterServiceimpl.getProducts(productPage, productSearchCriteria).getTotalElements());
}
}