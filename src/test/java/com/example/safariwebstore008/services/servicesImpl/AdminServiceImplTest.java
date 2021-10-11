package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class AdminServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void createDispatchRider() {
        final User user = new User();
        user.setFirstName("David");
        user.setLastName("Baba");
        user.setGender(Gender.MALE);
        user.setEmail("dave@gmail.com");
        user.setPassword(passwordEncoder.encode("dave1234"));
        user.setRoles(Roles.DISPATCH_RIDER);
        user.setIsEnabled(true);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User savedUser = adminService.createDispatchRider(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser).isEqualTo(user);

       Mockito.verify(userRepository).save(BDDMockito.any(User.class));
    }
}