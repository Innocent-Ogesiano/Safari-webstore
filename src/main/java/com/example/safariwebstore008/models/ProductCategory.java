package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category_table")
public class ProductCategory extends BaseClass {

    @NotNull(message = "Product category name is empty")
    private  String productCategoryName;
}
