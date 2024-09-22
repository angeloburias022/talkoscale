package com.devlou.talkoscale.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // Endpoint for sending messages
    @SendTo("/topic/messages") // Destination where messages will be sent
    public String sendMessage(String message) {
        // its not sending here..
        log.info("Sending message: {}", message); // Log the message being sent
        return message; // Return the message to the topic
    }
}
