package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class DispatchRider extends UserModel{
    public DispatchRider( String firstName, String lastName, Date dateOfBirth, String email, Gender gender,
                         LocalDateTime createDate, LocalDateTime updateDate) {
        super (firstName, lastName, dateOfBirth, email, gender);
    }
    public DispatchRider() {
    }
    @OneToMany
    private List<CustomerOrder>assignedOrders;
    @OneToOne
   private State_Pronvices coverage;

    private Roles roles;
}
