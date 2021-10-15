package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.ForgotPasswordDTO;
import com.example.safariwebstore008.dto.ResetPasswordDto;
import com.example.safariwebstore008.exceptions.AdminNotFoundException;
import com.example.safariwebstore008.models.Admin;
import com.example.safariwebstore008.repositories.AdminRepository;
import com.example.safariwebstore008.services.EmailService;
import com.example.safariwebstore008.services.PasswordService;
import javassist.NotFoundException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64.Encoder;

public class PasswordServiceImpl implements PasswordService {

    private final AdminRepository adminRepository;
    private final EmailService emailService;

    @Autowired
    public PasswordServiceImpl(AdminRepository adminRepository, EmailService emailService) {
        this.adminRepository = adminRepository;
        this.emailService = emailService;
    }

    @Override
    public String generateResetToken(ForgotPasswordDTO forgotPasswordDTO){
        Admin admin = adminRepository.findAdminByEmail(forgotPasswordDTO.getEmail());

        if (admin != null) {
            String token = RandomString.make(7);
            String email = forgotPasswordDTO.getEmail();
            String subject = "Reset Password";
            String text = "Use this token to generate your new password" + token;
            admin.setResetPasswordToken(token);
            adminRepository.save(admin);
            emailService.sendEmail(email, subject, token);
            return "Reset token sent to email";
        }
        throw new AdminNotFoundException("Incorrect Email");
    }

    @Override
    public String resetPassword(ResetPasswordDto resetPasswordDto) {
        Admin admin = adminRepository.findAdminByResetPasswordToken(resetPasswordDto.getToken());
        if (admin != null){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(resetPasswordDto.getNewPassword());
            admin.setPassword(password);
            admin.setResetPasswordToken(null);
            adminRepository.save(admin);
            return "Password reset successful";
        }
        throw new AdminNotFoundException("Supply a valid token");
    }
}
