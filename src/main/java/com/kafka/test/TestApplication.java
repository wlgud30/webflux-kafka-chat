package com.kafka.test;

import com.kafka.test.config.WebFluxWebSocketHandler;
import com.kafka.test.webclient.KafkaWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.HandshakeWebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestApplication.class, args);

		KafkaWebClient kafkaWebClient = new KafkaWebClient();
		kafkaWebClient.consume();
	}
//
//	@Bean
//	public WebFluxWebSocketHandler webSocketHandler() {
//		return new WebFluxWebSocketHandler();
//	}
//
//	@Bean
//	public HandlerMapping handlerMapping() {
//		Map<String, WebSocketHandler> map = new HashMap<>();
//		map.put("/my-chat", webSocketHandler());
//
//		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//		mapping.setUrlMap(map);
//		mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return mapping;
//	}
//
//	@Bean
//	public WebSocketHandlerAdapter handlerAdapter() {
//		return new WebSocketHandlerAdapter(webSocketService());
//	}
//
//	@Bean
//	public WebSocketService webSocketService() {
//		return new HandshakeWebSocketService(new ReactorNettyRequestUpgradeStrategy());
//	}

}
