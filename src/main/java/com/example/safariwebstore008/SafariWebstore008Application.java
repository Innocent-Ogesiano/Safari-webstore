package com.example.safariwebstore008;

import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.services.servicesImpl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.mail.MessagingException;

@SpringBootApplication
@EnableSwagger2
public class SafariWebstore008Application {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(SafariWebstore008Application.class, args);

    }

}
