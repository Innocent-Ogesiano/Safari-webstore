package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.configurations.JwtTokenUtil;
import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.exceptions.AccountNotEnabledException;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.ForgotPasswordService;
import com.example.safariwebstore008.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;


    @Override
    public boolean generateResetToken (String email) throws MessagingException {
        boolean status = false;

        UserDetails userDetails= jwtUserDetailsService.loadUserByUsername(email);
            String token = jwtTokenUtil.generateToken(userDetails);
            String subject = "Password Reset Token";
            MailDto mailDto= new MailDto();
            mailDto.setTo(email);
            mailDto.setSubject(subject);
            String resetPasswordUrl = "https://localhost:8080/resetPassword/" + token;
            mailDto.setBody("click on this link to generate your new password: " + resetPasswordUrl);
            mailService.sendMail(mailDto);

            if(mailDto.getBody()!=null && mailDto.getSubject()!=null && mailDto.getTo() != null){
                status = true;
            }

        return status;
    }

    @Override
    public User resetPassword(ResetPasswordDto resetPasswordDto, String token) {
        String userEmail= jwtTokenUtil.getUserEmailFromToken(token);
        Optional<User> user = userRepository.findUserByEmail(userEmail);
        if(user.isPresent()){
            user.get().setPassword(passwordEncoder.encode(resetPasswordDto.getNewPassword()));
           return userRepository.save(user.get());
        }else{
            throw new AccountNotEnabledException("User not enabled");
        }


    }




    }
