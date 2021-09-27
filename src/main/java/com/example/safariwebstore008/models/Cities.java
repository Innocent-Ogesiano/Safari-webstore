package com.example.safariwebstore008.models;

import javax.persistence.*;

@Entity
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private  String cityName;
}
