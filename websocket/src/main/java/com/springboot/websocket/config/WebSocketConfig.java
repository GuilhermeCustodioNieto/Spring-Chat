package com.springboot.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Ativa o websocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { // Intterface para configurações do nosso webSocket

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { // Método que registra um endpoint ao webSocket
        registry.addEndpoint("/websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { // Registra o gerenciador de mensagens
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
