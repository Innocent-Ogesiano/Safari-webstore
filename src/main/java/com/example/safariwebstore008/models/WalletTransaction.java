package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_transaction_table")
@Entity
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Null(message = "transaction date field is empty")
    private Date transactionDate;

    private TransactionType transactionType;
    @Null(message = "amount field is empty")
    private Double amount;

    @ManyToOne
    private Customer customer;

}
