package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

public class UserController {
    UriComponentsBuilder uriComponentsBuilder;
    @Autowired
    private AuthenticationManager authenticationManager;

    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PutMapping("/updatePassword/{userEmail}")
    private ResponseEntity<User> updatePassword(@RequestParam UpdatePasswordDto updatePasswordDto, @PathVariable("userEmail") String email) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, updatePasswordDto.oldPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        User user = userServices.updatePassword(updatePasswordDto, email);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
