package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;



@Data
@Entity
@Table(name = "admin_table")
public class Admin extends UserModel {
    public Admin(Long id, String firstName, String lastName, Date dateOfBirth, String email,
                 Gender gender, LocalDateTime createDate, LocalDateTime updateDate) {
        super(id, firstName, lastName, dateOfBirth, email, gender, createDate, updateDate);
    }

    public Admin() {
    }
    @OneToMany
    private List<AdminAccountDetails>listOfAdminAccounts;
@Null(message = "role field is empty or null")
 private Roles roles;
}
