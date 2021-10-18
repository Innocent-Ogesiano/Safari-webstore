package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.services.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {


    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void sendMail(MailDto mailDto) throws MessagingException {
        MimeMessage message  = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mailDto.getTo());
        helper.setSubject(mailDto.getSubject());
        helper.setText(mailDto.getBody(), true);
        mailSender.send(message);

    }
}