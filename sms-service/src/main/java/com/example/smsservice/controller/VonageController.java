package com.example.smsservice.controller;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("smsService")
public class VonageController {

    @GetMapping("sms")
    public void send() {
        VonageClient client = VonageClient.builder()
                .apiKey("ae77131c")
                .apiSecret("ps11otmsAaCdDRYD")
                .build();

        TextMessage message = new TextMessage("Vonage APIs",
                "79085443924",
                "testing"
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() != MessageStatus.OK) {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        } else {
            System.out.println("sms was sent");
        }
    }

}
