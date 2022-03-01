package com.example.emailservice.config;

import com.example.emailservice.model.ConnectionProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    private final ConnectionProperty connectionProperty;

    public EmailConfig(ConnectionProperty connectionProperty) {
        this.connectionProperty = connectionProperty;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(connectionProperty.getHost());
        mailSender.setPort(connectionProperty.getPort());
        mailSender.setUsername(connectionProperty.getUsername());
        mailSender.setPassword(connectionProperty.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", connectionProperty.getSmtpAuth());
        props.put("mail.smtp.starttls.enable", connectionProperty.getEnableStarttls());
        props.put("mail.debug", "true");

        return mailSender;
    }

}
