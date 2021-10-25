package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigInteger;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products_table")
public class Product extends BaseClass {

    @NotNull(message = "Product Name is empty")
    private String productName;

    @NotNull(message = "Description field is empty")
    private String description;

    @NotNull(message = "product price field is empty")
    private BigInteger price;

    private String colors;


}
