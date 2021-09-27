package com.example.safariwebstore008.models;

import javax.persistence.*;

@Entity
public class DeliveryMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private  String deliveryMethod;

    @OneToOne(mappedBy = "deliveryMethod")
    private  Customerord orders;
}