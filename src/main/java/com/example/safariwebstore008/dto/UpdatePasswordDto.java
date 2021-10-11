package com.example.safariwebstore008.dto;

import lombok.Data;

@Data
public class UpdatePasswordDto {
    public String newPassword;
    public String oldPassword;
}
