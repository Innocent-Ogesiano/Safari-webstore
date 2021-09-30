package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class DispatchRider extends UserModel{
    public DispatchRider( String firstName, String lastName, Date dateOfBirth,
                         String email, Gender gender,Roles roles,String password,Boolean isEnabled) {
        super (firstName, lastName, dateOfBirth, email, gender,roles,password,isEnabled);
    }
    public DispatchRider() {
    }
    @OneToMany
    private List<CustomerOrder>assignedOrders;
    @OneToOne
   private StatePronvices coverage;

}
