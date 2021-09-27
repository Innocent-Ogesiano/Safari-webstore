package com.example.safariwebstore008.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AdminAccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private  String bankName;
    private  String accountType;
    private  String accountNumber;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
