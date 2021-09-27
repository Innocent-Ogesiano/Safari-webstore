package com.example.safariwebstore008.models;

import javax.persistence.*;

@Entity
public class OrdDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Integer quantity;
    private  Double price;
    @OneToOne
    private  Products product;


}
