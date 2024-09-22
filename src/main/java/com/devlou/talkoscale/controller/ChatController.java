package com.devlou.talkoscale.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.devlou.talkoscale.dto.Message;
import com.devlou.talkoscale.dto.TypingMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatController {
     private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage") // Endpoint for sending messages
    public void sendMessage(Message message) {
        log.info("Sending message: {}", message.getText()); // Log the message being sent
        messagingTemplate.convertAndSend("/topic/messages", message); // Broadcast to all subscribers
    }

    @MessageMapping("/typing")
    public void typing(TypingMessage message) {
        log.info("{} is typing...", message.getTyping()); // unable to reacht here
        messagingTemplate.convertAndSend("/topic/typing", message);
    }

    @MessageMapping("/join")
    public void userJoined(Message message) {
        log.info("{} has joined the chat.", message.getUser());
        messagingTemplate.convertAndSend("/topic/userJoined", message);
    }
}
