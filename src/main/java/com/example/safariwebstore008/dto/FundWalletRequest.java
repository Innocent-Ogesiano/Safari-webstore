package com.example.safariwebstore008.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundWalletRequest {
    private Double amount;
    private Date transactionDate;
    private String email;
}
