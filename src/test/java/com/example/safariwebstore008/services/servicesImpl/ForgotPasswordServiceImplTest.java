package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.configurations.JwtTokenUtil;
import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
class ForgotPasswordServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private ForgotPasswordServiceImpl forgotPasswordService;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtTokenUtil jwtTokenUtil;

    @Test
    void resetPasswordSuccessfully() {
       Optional<User> user =  Optional.of(new User());
        user.get().setEmail("bigbaby@gmail.com");
        user.get().setPassword("0987");
        String token = "";

        ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
        resetPasswordDto.setNewPassword("1234");

        User user2 = new User();
        user2.setPassword("1234");

        Mockito.when(jwtTokenUtil.getUserEmailFromToken(token)).thenReturn(user.get().getEmail());
        Mockito.when(userRepository.findUserByEmail(user.get().getEmail())).thenReturn(user);
        Mockito.when(passwordEncoder.encode(resetPasswordDto.getNewPassword())).thenReturn("");
        Mockito.when(userRepository.save(user.get())).thenReturn(user2);
        User user1= forgotPasswordService.resetPassword(resetPasswordDto,token);

        Assertions.assertThat(user1.getPassword()).isEqualTo(resetPasswordDto.getNewPassword());


    }
}