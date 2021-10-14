package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_transaction_table")
@Entity
public class WalletTransaction extends BaseClass {


    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotNull (message = "transaction date field is empty")
    private Date transactionDate;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @NotNull(message = "amount field is empty")
    private Double amount;

    @ManyToOne
    private User userModel;

    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;


}
