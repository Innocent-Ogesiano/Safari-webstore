package com.example.safariwebstore008.dto;

import com.example.safariwebstore008.models.ProductCategory;
import com.example.safariwebstore008.models.ProductSubCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigInteger;


@Data
public class ProductDto {

    private String productName;
    private String description;
    private BigInteger price;
    private String color;
    private String size;
    private String categoryName;
    private String subCategoryName;
}
