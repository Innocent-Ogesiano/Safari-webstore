package com.example.safariwebstore008;

import com.example.safariwebstore008.models.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SafariWebstore008Application {

    public static void main(String[] args) {
        SpringApplication.run(SafariWebstore008Application.class, args);
    }
}
