package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.models.User;

import javax.mail.MessagingException;

public interface ForgotPasswordService {
    boolean generateResetToken(String email) throws MessagingException;
    User resetPassword(ResetPasswordDto resetPasswordDto, String token);
}
