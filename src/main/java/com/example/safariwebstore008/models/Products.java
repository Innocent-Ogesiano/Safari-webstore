package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products_table")
public class Products  extends BaseClass {

    @Null(message = "Description field is empty")
    private String description;

    @Null(message = "product price field is empty")
    private Double price;

    @OneToOne(mappedBy = "products")
    private Favourites favourites;
    @OneToMany
    private List<Colors>listOfProductColors;


}
