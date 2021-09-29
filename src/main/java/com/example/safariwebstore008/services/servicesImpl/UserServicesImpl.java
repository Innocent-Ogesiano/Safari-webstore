package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor

public class UserServicesImpl implements UserServices {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public User registerNewUser(RegistrationDto registrationDto) {
        User user = userRepository.findByEmailOrUsername(registrationDto.getEmail(), registrationDto.getUsername());
        if (user == null) {
            user = new User();
            user.setEmail(registrationDto.getEmail());
            user.setUsername(registrationDto.getUsername());
            user.setPassword(registrationDto.getPassword());
            user.setRole(registrationDto.getRole());
            user.setVerified(false);
            userRepository.save(user);
            log.info("Registration Successful, Please check your email for your verification link");
            //TODO: put generate token methods and assign it to string below
            //String tokenString = generateToken();
            //user.setVerificationToken(tokenString);
            //TODO: make this port the active port
            //String url = "http://localhost:8080/validate-registration-token/" + tokenString;
            //String html = "Welcome to safari webstore, please validate your account with the link below:   " + url;
            //TODO put mailservice here to send user email
            //mailService.sendMail(user.getEmail(), html);
        } else {
            log.info("Email/Username already exist in the database");
            throw new IllegalStateException("User with Email "+user.getEmail()+" or User with Username "
                    +user.getUsername()+" already exist");
        }
        return user;
    }

    @Override
    public User validateRegistrationToken(String tokenString){
        //TODO code to validate if token is valid and has not expired
        User user = userRepository.findByVerficationToken(tokenString);
        user.setVerified(true);
        userRepository.save(user);
        return user;
    }
}
