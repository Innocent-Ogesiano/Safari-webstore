package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.services.MailService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.mail.MessagingException;

//@SpringBootTest
//class MailServiceImplTest {
//   @Autowired
//    private MailService mailService;
//    @Test
//    void mustSendMail() throws MessagingException {
//        MailDto mailDto = new MailDto();
//        mailDto.setTo("himole22@gmail.com");
//        mailDto.setSubject("TEST MAIL");
//        mailDto.setBody("This is a test email for testing the service");
//        System.out.println(mailDto.getBody());
//        mailService.sendMail(mailDto);
//
//    }
//}