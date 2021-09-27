package com.example.safariwebstore008.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String firstName;
    private  String lastName;
    private  String email;
    private  String phoneNumber;
//    @ManyToOne
//    private  Customer customerDetails;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
//    @ManyToOne
//    private State_Pronvices listOfState;
}
