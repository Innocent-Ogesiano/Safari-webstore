package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details_table")
public class OrderDetails extends BaseClass {

    private Integer quantity;

    private  Double price;

    @OneToOne
    private  Products product;


}
