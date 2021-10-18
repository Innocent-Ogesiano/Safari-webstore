
package com.example.safariwebstore008.services;

import com.example.safariwebstore008.dto.MailDto;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface MailService {

    void sendMail(MailDto mailDto) throws MessagingException;
}