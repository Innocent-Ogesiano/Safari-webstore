package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_table")
@Entity
public class Wallet extends BaseClass {


    @OneToOne(mappedBy = "customerWallet")
    private  Customer customer;

    private Double walletBalance;


}
