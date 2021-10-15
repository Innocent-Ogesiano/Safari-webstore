package com.example.safariwebstore008.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ResetPasswordDto {
    @NotNull
    String newPassword;
    @NotNull
    String token;
}
