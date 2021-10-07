package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_subcategory_table")
public class ProductSubCategory extends BaseClass {
    @NotNull(message="category name is empty")
    private String categoryName;
    @ManyToOne
    private  ProductCategory category;
}
