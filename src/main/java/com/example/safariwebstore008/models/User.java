package com.example.safariwebstore008.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    private String role;
    private String password;
    private String verificationToken;
    private boolean verified;
}
