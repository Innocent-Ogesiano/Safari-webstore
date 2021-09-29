package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.ForgotPasswordDTO;
import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.exceptions.AdminNotFoundException;
import com.example.safariwebstore008.services.PasswordService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/forgot-password")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/generate-token")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) throws AdminNotFoundException {
        String message =passwordService.generateResetToken(forgotPasswordDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ResetPasswordDto resetPasswordDto) throws AdminNotFoundException {
        String message = passwordService.resetPassword(resetPasswordDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
