package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.enums.Gender;
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

import javax.security.auth.login.AccountNotFoundException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UpdateUserTest {

    @InjectMocks
    private UserServicesImpl userServicesImpl;

    @Mock
    private UserRepository userRepository;

    @Test
    void updateCustomer() throws AccountNotFoundException {
//        UserServicesImpl updateUser = new UserServicesImpl();
        User users = new User();
        users.setGender(Gender.MALE);

        users.setPassword("test1234");
        users.setFirstName("Tom");
        users.setLastName("Jerry");
        users.setEmail("jerryT@example.com");


        UpdateCustomerDto updateCustomerDto = new UpdateCustomerDto("John","Doe");


        User updatedUser = new User();
        updatedUser.setFirstName(updateCustomerDto.getFirstName());
        updatedUser.setLastName(updateCustomerDto.getLastName());

        BDDMockito.given(userRepository.save(users)).willReturn(users);
        Mockito.when(userRepository.save(users)).then(invocation -> invocation.getArgument(0));
        Mockito.when(userRepository.findUserByEmail(users.getEmail())).thenReturn(Optional.of(users));

        User user2= userServicesImpl.updateCustomer(updateCustomerDto,users.getEmail());

        Assertions.assertThat(user2.getFirstName()).isEqualTo(updateCustomerDto.getFirstName());

    }
}