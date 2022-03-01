package com.example.emailservice.controller;

import com.example.emailservice.service.EmailSenderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emailService")
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/email")
    public void sendEmail() {
        emailSenderService.sendEmail();
        System.out.println("email was sent");
    }

}
