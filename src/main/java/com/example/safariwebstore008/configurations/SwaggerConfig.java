package com.example.safariwebstore008.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
<<<<<<< HEAD
import springfox.documentation.service.ApiInfo;
=======
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
>>>>>>> 2013a07ed7073e91fb9692bda0375e4f0dab2a43
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

<<<<<<< HEAD
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
=======
import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
>>>>>>> 2013a07ed7073e91fb9692bda0375e4f0dab2a43

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
<<<<<<< HEAD
                .select().apis(RequestHandlerSelectors.basePackage("com.example.safariwebstore008"))
                .paths(regex("/api.*")).build().apiInfo(apiInfo());
=======
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.safariwebstore008"))
                .paths(PathSelectors.any())
                .build();
>>>>>>> 2013a07ed7073e91fb9692bda0375e4f0dab2a43
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Ecommerce API", "This ia an Ecommerce api", "v1.5", "Terms of Service",
                "Mike Od", "Apache Licence version 2.0", "https://www.apache.org/license.html");
    }
}
