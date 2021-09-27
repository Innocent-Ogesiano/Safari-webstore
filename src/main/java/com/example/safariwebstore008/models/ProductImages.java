package com.example.safariwebstore008.models;

import javax.persistence.*;

@Entity
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imageURl;
    @ManyToOne
    private Products product;

}
