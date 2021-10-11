package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Component
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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


    @Override
    public User updateCustomer(UpdateCustomerDto updateCustomerDto, String email) throws AccountNotFoundException {
        Optional<User> optionalUsers = userRepository.findUserByEmail(email);
        if(optionalUsers.isPresent()){
            User customer = optionalUsers.get();
            customer.setFirstName(updateCustomerDto.getFirstName());
            customer.setLastName(updateCustomerDto.getLastName());
            customer.setEmail(updateCustomerDto.getEmail());
            customer.setGender(updateCustomerDto.getGender());
            customer.setDateOfBirth(updateCustomerDto.getDateOfBirth());
            return userRepository.save(customer);
        } else{
            throw new AccountNotFoundException("User account not found");
        }
    }
}
