package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignOrders extends BaseClass {

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToOne
    private CustomerOrder orders;

}
