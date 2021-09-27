package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DispatchRider extends UserModel{
    public DispatchRider(Long id, String firstName, String lastName, Date dateOfBirth, String email, Gender gender,
                         LocalDateTime createDate, LocalDateTime updateDate) {
        super(id, firstName, lastName, dateOfBirth, email, gender, createDate, updateDate);
    }
    public DispatchRider() {
    }
    @OneToMany
    private List<Customerord>assignedOrders;
    @OneToOne
   private State_Pronvices coverage;

    private Roles roles;
}
