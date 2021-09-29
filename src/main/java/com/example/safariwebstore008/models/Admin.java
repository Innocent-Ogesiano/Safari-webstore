package com.example.safariwebstore008.models;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Admin extends User{
    String resetPasswordToken;
}
