package com.example.safariwebstore008;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.mail.MessagingException;

@SpringBootApplication
@EnableSwagger2
public class SafariWebstore008Application {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(SafariWebstore008Application.class, args);
    }
}
