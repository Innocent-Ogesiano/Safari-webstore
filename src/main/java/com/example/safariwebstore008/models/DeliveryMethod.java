package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "delivery_method_table")
public class DeliveryMethod extends BaseClass {

    private  String deliveryMethod;

    @OneToOne
    private CustomerOrder orders;
}