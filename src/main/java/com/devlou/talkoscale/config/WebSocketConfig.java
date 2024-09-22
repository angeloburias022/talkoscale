package com.devlou.talkoscale.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    public WebSocketConfig() {
        log.info("[TRACE] WebSocket configuration initializing...");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        log.info("[TRACE] Configuring message broker...");
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        log.info("[TRACE] Registering STOMP endpoints...");
        registry.addEndpoint("/ws")
        .setAllowedOriginPatterns("*"); // Adjust according to your client URL
                // .withSockJS(); // Enable SockJS fallback
    }


}
