package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_table")
@Entity
public class Cart extends BaseClass {

    @ManyToOne
    private  Products product;

    private  Double price;

    private  Integer quantity;

    @ManyToOne
    private  Customer customer;


}
