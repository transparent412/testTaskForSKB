package com.example.emailservice.service.impl;

import com.example.emailservice.model.ConnectionProperty;
import com.example.emailservice.service.EmailSenderService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final ConnectionProperty connectionProperty;
    private final JavaMailSender javaMailSender;

    public EmailSenderServiceImpl(ConnectionProperty connectionProperty, JavaMailSender javaMailSender) {
        this.connectionProperty = connectionProperty;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(connectionProperty.getUsername());
        message.setTo("senderovoleg@gmail.com");
        message.setSubject("Testing");
        message.setText("Testing");

        javaMailSender. send(message);

    }


}
