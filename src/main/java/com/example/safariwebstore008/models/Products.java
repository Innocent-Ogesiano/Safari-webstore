package com.example.safariwebstore008.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double price;
    @OneToOne(mappedBy = "products")
    private Favourites favourites;
    @OneToMany
    private List<Colors>listOfProductColors;
    private  Enum  size;



}
