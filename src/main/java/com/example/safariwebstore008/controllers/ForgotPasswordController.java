package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.services.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
@PreAuthorize("hasAuthority('CUSTOMER')")
@RestController
public class ForgotPasswordController {
    @Autowired
    ForgotPasswordService forgotPasswordService;

    @GetMapping("/generateResetToken")
    public ResponseEntity<Object> generateResetToken(@RequestParam(name = "email") String email) throws MessagingException {
        forgotPasswordService.generateResetToken(email);
        return  new ResponseEntity<>("Token generated successfully", HttpStatus.OK);

    }


    @PostMapping("/resetPassword/{token}")
    public ResponseEntity<User> resetPassword(@PathVariable String token, @RequestBody ResetPasswordDto resetPasswordDto) {
        User user = forgotPasswordService.resetPassword(resetPasswordDto, token);
        return new ResponseEntity<>(user,  HttpStatus.OK);
    }
}
