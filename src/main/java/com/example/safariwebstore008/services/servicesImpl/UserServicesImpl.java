package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServicesImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User updatePassword(UpdatePasswordDto updatePasswordDto, String email) throws Exception {
        User user1 = userRepository.findUserByEmail(email).get();
        user1.setPassword(passwordEncoder.encode(updatePasswordDto.getNewPassword()));
        userRepository.save(user1);
        return user1;
    }
}
