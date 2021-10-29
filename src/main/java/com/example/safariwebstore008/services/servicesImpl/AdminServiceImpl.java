package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.ProductDto;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.exceptions.CustomAppException;
import com.example.safariwebstore008.models.*;
import com.example.safariwebstore008.repositories.*;
import com.example.safariwebstore008.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public User createDispatchRider(User dispatchRider) {
        User newDispatchRider = new User();
        newDispatchRider.setFirstName(dispatchRider.getFirstName());
        newDispatchRider.setLastName(dispatchRider.getLastName());
        newDispatchRider.setDateOfBirth(dispatchRider.getDateOfBirth());
        newDispatchRider.setGender(dispatchRider.getGender());
        newDispatchRider.setRoles(Roles.DISPATCH_RIDER);
        newDispatchRider.setEmail(dispatchRider.getEmail());
        newDispatchRider.setPassword(bcryptEncoder.encode(dispatchRider.getPassword()));
        newDispatchRider.setIsEnabled(true);
        return userRepository.save(newDispatchRider);
    }

    @Override
    public Product createProduct(ProductDto products) {
        Product newProduct = new Product();
        Optional<ProductCategory> productCategory = categoryRepository.findProductCategoryByProductCategoryName
                (products.getCategoryName());
        ProductCategory category;
        if (productCategory.isEmpty()) {
            category = new ProductCategory();
            category.setProductCategoryName(products.getCategoryName().toLowerCase());
            categoryRepository.save(category);
            newProduct.setCategory(category);
        } else {
            category = productCategory.get();
            newProduct.setCategory(category);
        }

        Optional<ProductSubCategory> productSubCategory = subCategoryRepository.findProductSubCategoryBySubCategoryName
                (products.getSubCategoryName());
        if (productSubCategory.isEmpty()){
            ProductSubCategory subCategory = new ProductSubCategory();
            subCategory.setSubCategoryName(products.getSubCategoryName().toLowerCase());
            subCategory.setCategory(category);
            subCategoryRepository.save(subCategory);
            newProduct.setSubCategory(subCategory);
        } else {
            newProduct.setSubCategory(productSubCategory.get());
        }

        newProduct.setProductName(products.getProductName().toLowerCase());
        newProduct.setDescription(products.getDescription());
        newProduct.setPrice(products.getPrice());
        newProduct.setColor(products.getColor().toLowerCase());
        newProduct.setSize(products.getSize().toUpperCase());
        productRepository.save(newProduct);
        return newProduct;
    }


    @Override
    public ProductImages saveToDB(String imageUrl, Long productId) {
        ProductImages productImages = new ProductImages();
        productImages.setImageURl(imageUrl);
        Optional<Product> optionalProduct = productRepository
                .findById(productId);
        if (optionalProduct.isPresent()) {
            productImages.setProduct(optionalProduct.get());
        } else {
            throw new CustomAppException("Product not existing");
        }
        return imageRepository.save(productImages);
    }
}