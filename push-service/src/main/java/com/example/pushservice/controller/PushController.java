package com.example.pushservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pushService")
public class PushController {
    @GetMapping("/push")
    public void send() {
        System.out.println("push was sent");
    }

}
