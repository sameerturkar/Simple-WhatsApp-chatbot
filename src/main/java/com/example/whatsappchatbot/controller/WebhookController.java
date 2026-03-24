package com.example.whatsappchatbot.controller;

import com.example.whatsappchatbot.model.MessageRequest;
import com.example.whatsappchatbot.model.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping
    public ResponseEntity<MessageResponse> receive(@RequestBody MessageRequest request) {
        String msg = request.getMessage() == null ? "" : request.getMessage().trim();
        String reply;
        if (msg.equalsIgnoreCase("hi")) {
            reply = "Hello";
        } else if (msg.equalsIgnoreCase("bye")) {
            reply = "Goodbye";
        } else {
            reply = "I don't understand";
        }
        MessageResponse response = new MessageResponse(reply);
        return ResponseEntity.ok(response);
    }
}
