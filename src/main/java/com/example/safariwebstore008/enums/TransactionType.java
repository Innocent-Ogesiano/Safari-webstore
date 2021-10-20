package com.example.safariwebstore008.enums;

public enum TransactionType {
    FUNDWALLET("fundwallet"),MAKEPAYMENT("makepayment"),WITHDRAWER("withdrawer");
   private final String transaction ;

    TransactionType(String transaction) {
        this.transaction = transaction;
    }
}
