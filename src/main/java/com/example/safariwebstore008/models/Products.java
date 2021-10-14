package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products_table")
public class Products  extends BaseClass {
    private String colors;
    @NotNull(message = "Description field is empty")
    private String description;
    @NotBlank(message = "product name field is empty")
    private  String productName;
    @NotNull(message = "product price field is empty")
    private Double price;

}
