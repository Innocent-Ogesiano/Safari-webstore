package com.example.safariwebstore008;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.mail.MessagingException;

@SpringBootApplication
public class SafariWebstore008Application {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(SafariWebstore008Application.class, args);


    }

}
