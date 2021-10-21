package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.dto.ProcessPaymentDTO;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.ProcessPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class ProcessPaymentServiceImpl implements ProcessPaymentService {

    private final UserRepository userRepository;

    @Autowired
    public ProcessPaymentServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ProcessPaymentDTO processPayment(CheckoutDto checkoutDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findUserByEmail(email).get();

        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        Double amount = checkoutDto.getTotalOrderAmount();
        ProcessPaymentDTO processPaymentDTO = new ProcessPaymentDTO();

        processPaymentDTO.setEmail(email);
        processPaymentDTO.setFirstName(firstName);
        processPaymentDTO.setLastName(lastName);
        processPaymentDTO.setAmount(amount);

        return processPaymentDTO;
    }


}
