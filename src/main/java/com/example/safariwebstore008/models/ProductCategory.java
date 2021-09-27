package com.example.safariwebstore008.models;

import javax.persistence.*;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private  String productCategoryName;
//    @ManyToOne
//    private  Products product;
}
