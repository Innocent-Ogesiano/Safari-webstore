package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_subcategory_table")
public class ProductSubCategory extends BaseClass {

    @NotNull(message="category name is empty")
    private String subCategoryName;
    @ManyToOne
    private  ProductCategory category;
}
