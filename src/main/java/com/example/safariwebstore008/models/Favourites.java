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
@Table(name = "customer_favourites_table")
public class Favourites extends BaseClass {


    @ManyToOne
    private Customer customer;

    @OneToOne
    private  Products products;

}