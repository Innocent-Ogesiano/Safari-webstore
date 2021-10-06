package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_table")
public class Cart extends BaseClass {

    @ManyToOne
    private  Products product;

    private  Double price;

    private  Integer quantity;

    @OneToOne
    private  UserModel userModel;

}
