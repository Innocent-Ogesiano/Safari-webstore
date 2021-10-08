package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MyUserDetails;
import com.example.safariwebstore008.exceptions.AccountNotEnabledException;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService  implements  UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
          Optional<User> userModel     = userRepository.findUserByEmail(userEmail);
          User user = userModel.get();
        if(user!=null){
            if(user.getIsEnabled()){
            return new MyUserDetails(user.getEmail(),user.getPassword(), user.getIsEnabled(), new ArrayList<>());
            }
            throw new AccountNotEnabledException("Account is disabled");
        }
        else{
            throw new UsernameNotFoundException("User not Found");
        }
    }

}
