package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServicesImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServicesImpl userService;

    @Test
    void passwordReset() throws Exception {
        User user = new User();
        user.setPassword("12345678");
        user.setFirstName("Inno");
        user.setLastName("Oge");
        user.setEmail("oge@gmail.com");
        user.setGender(Gender.MALE);
        user.setRoles(Roles.CUSTOMER);

        given(userRepository.save(user)).willReturn(user);
        UpdatePasswordDto passwordResetDto = new UpdatePasswordDto();
        passwordResetDto.setOldPassword("12345678");
        passwordResetDto.setNewPassword("87654321");
        given(userRepository.findUserByEmail("oge@gmail.com")).willReturn(Optional.of(user));
        final User expected = userService.updatePassword(passwordResetDto, user.getEmail());
        assertThat(expected.getPassword()).isNotEqualTo(passwordResetDto.getOldPassword());
        assertThat(expected.getEmail().equals(user.getEmail()));
    }
}