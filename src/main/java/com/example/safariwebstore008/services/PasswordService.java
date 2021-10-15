package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.ForgotPasswordDTO;
import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.exceptions.AdminNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface PasswordService {
    String generateResetToken(ForgotPasswordDTO forgotPasswordDTO) throws AdminNotFoundException;
    String resetPassword(ResetPasswordDto resetPasswordDto);
}
