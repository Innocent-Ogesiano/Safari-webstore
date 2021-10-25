package com.example.safariwebstore008.dto;

import com.example.safariwebstore008.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private Gender gender;
}
