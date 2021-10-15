package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShippingAddress extends BaseClass {

   @NotNull(message = "first-name field is empty")
    private String firstName;

    @NotNull(message = "last-name field is empty")
    private  String lastName;

    @NotNull(message = "email field is empty")
   @Email(message = "email is not properly formatted")
    private  String email;

    @NotNull(message = "phone number field is empty")
    private  String phoneNumber;
    @ManyToOne
    private StatePronvices state;
    @ManyToOne
   private Users userModel;
    private String RegionName;
    private String CityName;
}
