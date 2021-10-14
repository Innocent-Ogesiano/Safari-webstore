package com.example.safariwebstore008.services.servicesImpl.logintest;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.servicesImpl.JwtUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class JwtUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private JwtUserDetailsService jwtUserDetailsService;


    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setFirstName("David");
        user.setLastName("Baba");
        user.setGender(Gender.MALE);
        user.setEmail("dave@gmail.com");
        user.setPassword("dave1234");
        user.setRoles(Roles.CUSTOMER);
        user.setIsEnabled(true);

        Mockito.when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.of(user));
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getEmail());

        assertThat(userDetails.getUsername()).isEqualTo(user.getEmail());


        Mockito.verify(userRepository).findUserByEmail(user.getEmail());
    }
}