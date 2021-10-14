package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.configurations.JwtTokenUtil;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserController {
    UriComponentsBuilder uriComponentsBuilder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.userServices = userServices;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @PutMapping("/updatePassword/{token}")
    private ResponseEntity<User> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto, @PathVariable("token") String token) throws Exception {
        String email = jwtTokenUtil.getUserEmailFromToken(token);
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
