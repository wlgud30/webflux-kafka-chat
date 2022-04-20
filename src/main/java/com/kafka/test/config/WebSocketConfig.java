package com.kafka.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

//@EnableWebSocketMessageBroker
//@Configuration
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/my-chat").setAllowedOrigins("*").withSockJS();
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/kafka");
//        registry.enableSimpleBroker("/topic/");
//    }
//}
