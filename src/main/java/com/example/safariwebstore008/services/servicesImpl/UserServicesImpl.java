package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.models.Wallet;
import com.example.safariwebstore008.repositories.WalletRepository;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.safariwebstore008.dto.RegistrationDto;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final WalletRepository walletRepository;

    @Autowired
    public UserServicesImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
    @Override
    public Double checkWalletBalance(String email) {
        Optional<Wallet> userWallet = walletRepository.findWalletByUserEmail(email);
        if (userWallet.isPresent()) {
            Wallet wallet = userWallet.get();
            return wallet.getWalletBalance();
        }
        return null;
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
