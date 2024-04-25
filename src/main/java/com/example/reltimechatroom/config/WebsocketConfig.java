package com.example.reltimechatroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration

// kích hoạt websocket và xác định một message broker cho ứng dụng
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    // registry các endpoint WebSocket để client có thể kết nối và truyền dữ liệu
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // message đc gửi từ client tới server qua message broker với prefix "/app"
        registry.setApplicationDestinationPrefixes("/app");

        // message đc gửi từ server tới client qua message broker với prefix "/chatroom", "/user"
        registry.enableSimpleBroker("/chatroom", "/user");

        registry.setUserDestinationPrefix("/user");
    }
}
