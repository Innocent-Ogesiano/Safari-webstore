package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.dto.ProcessPaymentDTO;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration
class ProcessPaymentServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProcessPaymentServiceImpl paymentService;


    @Test
    void processPayment() {
        User user = new User();
        user.setEmail("ony@gmail.com");
        user.setFirstName("Ony");
        user.setLastName("Chris");
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Authentication authentication = mock(Authentication.class);
       Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
      UserDetails userDetails = org.springframework.security.core.userdetails.User.
                withUsername("ony@gmail.com").password("password").roles("USER").build();
       when(authentication.getPrincipal()).thenReturn(userDetails);
        CheckoutDto checkoutDto = new CheckoutDto();
        SecurityContextHolder.setContext(securityContext);
        Mockito.when((UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).thenReturn(userDetails);
        Mockito.when(userRepository.findUserByEmail(any())).thenReturn(Optional.of(user));

        checkoutDto.setTotalOrderAmount(17000D);

        ProcessPaymentDTO paymentDTO = new ProcessPaymentDTO();
        paymentDTO.setEmail(user.getEmail());
        paymentDTO.setFirstName(user.getFirstName());
        paymentDTO.setLastName(user.getLastName());
        paymentDTO.setAmount(checkoutDto.getTotalOrderAmount());
        ProcessPaymentDTO expected = paymentService.processPayment(checkoutDto);
        assertEquals(expected.getEmail(), paymentDTO.getEmail());

    }
}


