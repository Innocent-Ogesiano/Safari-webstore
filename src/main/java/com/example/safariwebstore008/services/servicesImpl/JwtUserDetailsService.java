package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MyUserDetails;
import com.example.safariwebstore008.exceptions.AccountNotEnabledException;
import com.example.safariwebstore008.models.Admin;
import com.example.safariwebstore008.models.Customer;
import com.example.safariwebstore008.repositories.AdminRepository;
import com.example.safariwebstore008.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Admin admin = adminRepository.findAdminByEmail(userEmail);
        Customer customer= customerRepository.findCustomerByEmail(userEmail);
        if(admin!=null){
            if(admin.getIsEnabled()==true){
            return new MyUserDetails(admin.getEmail(), admin.getPassword(), admin.getIsEnabled(), new ArrayList<>());
            }
            throw new AccountNotEnabledException("Account is disabled");
        }
        else if(customer!=null){
            if(customer.getIsEnabled()==true){
            return new MyUserDetails(customer.getEmail(), customer.getPassword(), customer.getIsEnabled(), new ArrayList<>());
        }
            throw new AccountNotEnabledException("Account is disabled");
        }
        else{
            throw new UsernameNotFoundException("User not Found");
        }
    }

}
