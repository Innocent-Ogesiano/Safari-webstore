package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Admin;
import com.example.safariwebstore008.models.Customer;
import com.example.safariwebstore008.repositories.AdminRepository;
import com.example.safariwebstore008.repositories.CustomerRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Admin admin = adminRepository.findUserByEmail(userEmail);
        Customer customer= customerRepository.findCustomerByEmail(userEmail);
        if(admin!=null){
            return new User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
        }
        else if(customer!=null){
            return new User (customer.getEmail(), customer.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not Found");
        }
    }
}
