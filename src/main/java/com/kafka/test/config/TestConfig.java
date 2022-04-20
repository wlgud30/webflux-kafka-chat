package com.kafka.test.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class TestConfig {

    private final WebFluxWebSocketHandler handler;

    @Bean
    public HandlerMapping handlerMapping(){
        Map<String, WebFluxWebSocketHandler> handlerMap = Map.of(
                "/uppercase", handler
        );
        return new SimpleUrlHandlerMapping(handlerMap, 1);
    }
}
