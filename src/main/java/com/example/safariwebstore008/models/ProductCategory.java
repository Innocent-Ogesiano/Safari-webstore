package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category_table")
public class ProductCategory extends BaseClass {

    @Null(message = "Product category name is empty")
    private  String productCategoryName;

    @ManyToOne
    private  Products product;
}
