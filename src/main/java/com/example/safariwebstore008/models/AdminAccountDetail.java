package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_account_details_table")
public class AdminAccountDetail extends BaseClass {
    @NotNull(message = "bank name field is empty field is empty")
    private  String bankName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @NotNull(message = "Account number field is empty")
    private  String accountNumber;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Users user;
}
