package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContactDetails extends BaseClass {

    @Null(message = "first-name field is empty")
    private String firstName;

    @Null(message = "last-name field is empty")
    private  String lastName;

    @Null(message = "email field is empty")
   @Email(message = "email is not properly formatted")
    private  String email;

    @Null(message = "phone number field is empty")
    private  String phoneNumber;

    @ManyToOne
    private State_Pronvices listOfState;
}
