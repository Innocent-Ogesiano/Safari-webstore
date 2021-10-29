package com.example.safariwebstore008;


import com.cloudinary.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.Value;


import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
@Component
public class SafariWebstore008Application {

    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(SafariWebstore008Application.class, args);

    }
}
