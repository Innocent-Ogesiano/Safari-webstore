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
@Table(name = "product_image_table")
public class ProductImages extends BaseClass {

    @Null(message = "imageUrl isempty")
    private String imageURl;

    @ManyToOne
    private Products product;

}
