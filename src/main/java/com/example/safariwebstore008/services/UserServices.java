package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    User signup(RegistrationDto registrationDto);
    User updatePassword(UpdatePasswordDto passwordRestDto, String email) throws Exception;
}
