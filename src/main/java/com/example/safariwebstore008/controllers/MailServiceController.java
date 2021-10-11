package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/send-notification")
public class MailServiceController {

    private final MailService mailService;

    @Autowired
    public MailServiceController(MailService mailService) {
        this.mailService = mailService;
    }


    @PostMapping
    public void sendNotification(@RequestBody MailDto mailDto) throws MessagingException {
        mailService.sendMail(mailDto);
    }
}
