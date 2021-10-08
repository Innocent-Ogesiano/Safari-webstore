package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public User updateCustomer(UpdateCustomerDto updateCustomerDto, String email) throws AccountNotFoundException {
        Optional<User> optionalUsers = userRepository.findUserByEmail(email);
        if(optionalUsers.isPresent()){
            User customer = optionalUsers.get();
            customer.setFirstName(updateCustomerDto.getFirstName());
            customer.setLastName(updateCustomerDto.getLastName());
            return userRepository.save(customer);
        } else{
            throw new AccountNotFoundException("User account not found");
        }
    }
}
