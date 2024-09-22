package com.devlou.talkoscale;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.devlou.talkoscale.config.WebSocketConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class TalkoscaleApplicationTests {


 	@MockBean
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private WebSocketConfig webSocketConfig;

	@Test
	void contextLoads() {
	}

	@Test
	void testMessageSending() {
		String destination = "/topic/messages";
		String message = "Test message";

		log.info("Sending message '{}' to destination '{}'", message, destination);

		// Simulate sending a message
		messagingTemplate.convertAndSend(destination, message);

		// Verify that the message was sent to the correct destination
		verify(messagingTemplate, times(1))
		.convertAndSend(destination, message); // why i can it in the verify method?

		log.info("Message '{}' sent to destination '{}'", message, destination);
	}

	@Test
	void testWebSocketConfiguration() {
		log.info("Testing WebSocket configuration");

		// Basic verification that the WebSocketConfig is loaded
		assert (webSocketConfig != null);
		log.info("WebSocketConfig is loaded successfully");
	}

}
