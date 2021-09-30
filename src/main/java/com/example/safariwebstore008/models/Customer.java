package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "customer_details_table")
public class Customer extends UserModel{
    public Customer(String firstName, String lastName, Date dateOfBirth, String email,
                    Gender gender, Roles roles,String password) {
        super(firstName, lastName, dateOfBirth, email, gender,roles,password);
    }

    public Customer() {
    }
    @OneToMany
    private List<CustomerOrder>customer_orders;

    @OneToOne
    private Wallet customerWallet;

}
