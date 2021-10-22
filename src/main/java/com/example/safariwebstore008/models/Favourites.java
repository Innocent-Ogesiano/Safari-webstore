package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_favourites_table")
public class Favourites extends BaseClass {


    @OneToOne
    private User userModel;
    @OneToMany
    private List<Product> products;

}
