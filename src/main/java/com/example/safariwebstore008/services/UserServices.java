package com.example.safariwebstore008.services;

public interface UserServices {
    User signup(RegistrationDto registrationDto);
    User updatePassword(UpdatePasswordDto passwordRestDto, String email) throws Exception;
}
