package com.example.safariwebstore008.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class ForgotPasswordDTO {
    @Email(message = "provide a valid email")
    private String email;
}
