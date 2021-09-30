package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;



@Data
@Entity
@Table(name = "admin_table")
public class Admin extends UserModel {
    public Admin(String firstName, String lastName,
                 Date dateOfBirth, String email, Gender gender,Roles roles) {
        super(firstName, lastName, dateOfBirth, email, gender,roles);
    }
    public Admin() {
    }

    @OneToMany
    private List<AdminAccountDetails>listOfAdminAccounts;


}
