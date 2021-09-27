package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Admin extends UserModel {
    public Admin(Long id, String firstName, String lastName, Date dateOfBirth, String email,
                 Gender gender, LocalDateTime createDate, LocalDateTime updateDate) {
        super(id, firstName, lastName, dateOfBirth, email, gender, createDate, updateDate);
    }

    public Admin() {
    }
    @OneToMany
    private List<AdminAccountDetails>listOfAdminAccounts;

 private Roles roles;
}
