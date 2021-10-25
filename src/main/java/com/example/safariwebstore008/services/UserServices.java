package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.dto.UpdateUserDto;
import com.example.safariwebstore008.models.User;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public interface UserServices {
    User updateUser(UpdateUserDto updateUserDto, String email) throws AccountNotFoundException;
    User signup(RegistrationDto registrationDto);
    User updatePassword(UpdatePasswordDto passwordRestDto, String email) throws Exception;
}
