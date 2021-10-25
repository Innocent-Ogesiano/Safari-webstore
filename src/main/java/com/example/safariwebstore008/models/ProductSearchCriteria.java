package com.example.safariwebstore008.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class ProductSearchCriteria {
    private String color;
    private String subCategory;
    private String size;
    private String price;
}
