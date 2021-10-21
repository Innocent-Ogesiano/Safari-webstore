package com.example.safariwebstore008.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessPaymentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Double amount;
}
