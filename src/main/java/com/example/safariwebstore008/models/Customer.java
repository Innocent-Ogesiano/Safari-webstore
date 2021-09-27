package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends UserModel{
    public Customer(Long id, String firstName, String lastName, Date dateOfBirth, String email,
                    Gender gender, LocalDateTime createDate, LocalDateTime updateDate) {
        super(id, firstName, lastName, dateOfBirth, email, gender, createDate, updateDate);
    }

    public Customer() {
    }
    @OneToMany
    private List<Customerord>customer_orders;
//    @OneToOne
//    private Wallet customerWallet;
 private Roles roles;
}
