package com.example.safariwebstore008.dto;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Gender gender;


}
