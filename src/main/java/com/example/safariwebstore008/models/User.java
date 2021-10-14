package com.example.safariwebstore008.models;
import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;
@Builder
@Data
@Entity
@AllArgsConstructor
@Table(name = "users_table")
public  class User extends BaseClass {

    @NotEmpty(message = "first-name field is empty")
    private String firstName;

    @NotEmpty(message = "last-name is empty")
    private  String lastName;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotEmpty(message = "date field is empty")
    private Date dateOfBirth;

    @Email( message = "email field is not properly formatted")
    @NotEmpty(message = "email field is empty")
    @Column(unique = true)
    private  String email;

    @NotEmpty(message = "gender field is empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @NotEmpty(message = "password field is empty")
    @Size(min = 8,message = "The password character is less than 8")
    private String password;
    private Boolean isEnabled;
    private String dispatchRiderLocation;

    public User(Long id) {
        super(id);
    }
    public User(){

    }
}
