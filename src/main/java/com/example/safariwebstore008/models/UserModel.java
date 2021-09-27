package com.example.safariwebstore008.models;
import com.example.safariwebstore008.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String firstName;
    private  String lastName;
    private Date dateOfBirth;
    private  String email;
    private Gender gender;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    }
