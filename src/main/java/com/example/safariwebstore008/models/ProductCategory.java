package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category_table")
public class ProductCategory extends BaseClass {

    @NotNull(message = "Product category name is empty")
    private  String productCategoryName;

    @OneToMany
    private List<Product> product;
}
