package com.example.safariwebstore008.models;
import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@MappedSuperclass
public abstract class UserModel extends BaseClass {

    @Null(message = "first-name field is empty")
    private String firstName;

    @Null(message = "last-name is empty")
    private  String lastName;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Null(message = "date field is empty")
    private Date dateOfBirth;

    @Email( message = "email field is not properly formatted")
    @Null(message = "email field is empty")
    private  String email;

    @Null(message = "gender field is empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Roles roles;

    public UserModel(Long id) {
        super(id);
    }
    public UserModel(){

    }
}