package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.ProductDto;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.*;
import com.example.safariwebstore008.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class AdminServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private SubCategoryRepository subCategoryRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void createDispatchRider() {
        final User user = new User();
        user.setFirstName("David");
        user.setLastName("Baba");
        user.setGender(Gender.MALE);
        user.setEmail("dave@gmail.com");
        user.setPassword(passwordEncoder.encode("dave1234"));
        user.setRoles(Roles.DISPATCH_RIDER);
        user.setIsEnabled(true);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User savedUser = adminService.createDispatchRider(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser).isEqualTo(user);

       Mockito.verify(userRepository).save(BDDMockito.any(User.class));
    }

    @Test
    void createProduct() {
        ProductCategory category = new ProductCategory();
        category.setProductCategoryName("Clothes");
        categoryRepository.save(category);

        ProductSubCategory subCategory = new ProductSubCategory();
        subCategory.setSubCategoryName("Gucci");
        subCategory.setCategory(category);
        subCategoryRepository.save(subCategory);

        ProductDto product = new ProductDto();
        product.setProductName("gucci");
        product.setPrice(new BigInteger("20"));
        product.setColor("red");
        product.setSize("M");
        product.setDescription("It is nice");
        product.setCategoryName("clothes");
        product.setSubCategoryName("jeans");

        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setColor(product.getColor());
        newProduct.setSize(product.getSize());
        newProduct.setCategory(category);
        newProduct.setSubCategory(subCategory);

        Mockito.when(productRepository.save(newProduct)).thenReturn(newProduct);

        Product savedProduct = adminService.createProduct(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getProductName()).isEqualTo(product.getProductName());
        assertThat(savedProduct.getCategory().getProductCategoryName()).isEqualTo(product.getCategoryName());

        Mockito.verify(productRepository).save(BDDMockito.any(Product.class));

    }
}