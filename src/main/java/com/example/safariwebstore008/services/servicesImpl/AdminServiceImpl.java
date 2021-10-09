package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.Products;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public User createDispatchRider(User dispatchRider) {
        User newDispatchRider = new User();
        newDispatchRider.setFirstName(dispatchRider.getFirstName());
        newDispatchRider.setLastName(dispatchRider.getLastName());
        newDispatchRider.setDateOfBirth(dispatchRider.getDateOfBirth());
        newDispatchRider.setGender(dispatchRider.getGender());
        newDispatchRider.setRoles(Roles.DISPATCH_RIDER);
        newDispatchRider.setEmail(dispatchRider.getEmail());
        newDispatchRider.setPassword(bcryptEncoder.encode(dispatchRider.getPassword()));
        newDispatchRider.setIsEnabled(true);
        return userRepository.save(newDispatchRider);
    }
}
