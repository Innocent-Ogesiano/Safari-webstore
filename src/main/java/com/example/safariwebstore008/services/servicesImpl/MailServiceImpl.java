package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.services.MailService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Setter
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

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
