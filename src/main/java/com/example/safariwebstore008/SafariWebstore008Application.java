package com.example.safariwebstore008;

import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.Users;
import com.example.safariwebstore008.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@EnableSwagger2
public class SafariWebstore008Application {
    @Autowired
    private static UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(SafariWebstore008Application.class, args);
        Date date = new Date();
        Users admin = Users.builder()
                .dateOfBirth(date)
                .email("admin@gmail.com")
                .firstName("admin")
                .gender(Gender.MALE)
                .password("123456")
                .lastName("admin")
                .roles(Roles.ADMIN)
                .build();
     userRepository.save(admin);

    }
}
