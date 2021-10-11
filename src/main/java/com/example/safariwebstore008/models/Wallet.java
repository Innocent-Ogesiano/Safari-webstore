package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_table")
@Entity
public class Wallet extends BaseClass {


    @OneToOne
    private User user;

    private Double walletBalance;


}
