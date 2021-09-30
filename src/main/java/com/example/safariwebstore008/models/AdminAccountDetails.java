package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_account_details_table")
public class AdminAccountDetails extends BaseClass {
    @Null(message = "bank name field is empty field is empty")
    private  String bankName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Null(message = "Account number field is empty")
    private  String accountNumber;
}
