package com.example.safariwebstore008.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class FundWalletRequest {
    private Double amount;
    private Date transactionDate;
    private String email;
}
