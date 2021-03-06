package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.dto.UpdateUserDto;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service
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

    @Override
    public User updateUser(UpdateUserDto updateUserDto, String email) throws AccountNotFoundException {
        Optional<User> optionalUsers = userRepository.findUserByEmail(email);
        if(optionalUsers.isPresent()){
            User customer = optionalUsers.get();
            customer.setFirstName(updateUserDto.getFirstName());
            customer.setLastName(updateUserDto.getLastName());
            customer.setEmail(updateUserDto.getEmail());
            customer.setGender(updateUserDto.getGender());
            customer.setDateOfBirth(updateUserDto.getDateOfBirth());
            return userRepository.save(customer);
        } else{
            throw new AccountNotFoundException("User account not found");
        }
    }

    @Override
    public User signup(RegistrationDto registrationDto) {
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setDateOfBirth(registrationDto.getDateOfBirth());
        user.setGender(registrationDto.getGender());
        user.setRoles(Roles.CUSTOMER);
        user.setIsEnabled(true);

        return userRepository.save(user);
    }
}
