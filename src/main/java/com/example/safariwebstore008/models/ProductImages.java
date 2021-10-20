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
@Table(name = "product_image_table")
public class ProductImages extends BaseClass {

    @NotNull(message = "imageUrl isempty")
    private String imageURl;

    @ManyToOne
    private Product product;

}
