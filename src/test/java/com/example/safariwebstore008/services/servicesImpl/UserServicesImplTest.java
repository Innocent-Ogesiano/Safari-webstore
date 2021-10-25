package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.dto.UpdateUserDto;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
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

    @Test
    void updateUser() throws AccountNotFoundException {
        User users = new User();
        users.setGender(Gender.MALE);
        users.setDateOfBirth(new Date(1/4/1990));
        users.setPassword("test1234");
        users.setFirstName("Tom");
        users.setLastName("Jerry");
        users.setEmail("jerryT@example.com");


        UpdateUserDto updateUserDto = new UpdateUserDto("John","Doe","jerryT@example.com", new Date(1/4/1990),Gender.MALE);


        User updatedUser = new User();
        updatedUser.setFirstName(updateUserDto.getFirstName());
        updatedUser.setLastName(updateUserDto.getLastName());

        BDDMockito.given(userRepository.save(users)).willReturn(users);
        Mockito.when(userRepository.save(users)).then(invocation -> invocation.getArgument(0));
        Mockito.when(userRepository.findUserByEmail(users.getEmail())).thenReturn(Optional.of(users));

        User user2= userService.updateUser(updateUserDto,users.getEmail());

        Assertions.assertThat(user2.getFirstName()).isEqualTo(updateUserDto.getFirstName());

    }

}