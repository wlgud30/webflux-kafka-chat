package com.kafka.test.config;

import com.kafka.test.dto.kafka.KafkaMessageRequestDto;
import com.kafka.test.handler.KafkaHandler;
import com.kafka.test.producer.KafkaProducerTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@Slf4j
@EnableWebFlux
public class WebFluxKafkaConfig {

//    private final KafkaProducerTest kafkaProducer;




    @Bean
    public RouterFunction<ServerResponse> route(KafkaHandler kafkaHandler){
        return RouterFunctions.route()
                .GET("/kafka",req->ok().body(Mono.just(new KafkaMessageRequestDto("떴냐")), KafkaMessageRequestDto.class))
                .POST("/kafka",kafkaHandler::kafkaTest)
                .build();
    }
//
//    @Bean
//    RouterFunction<ServerResponse> getTest() {
//        log.info("kafka get methods");
//        return route(GET("/kafka"),
//                req -> ok().body(Mono.just(new KafkaMessageRequestDto("떴냐")), KafkaMessageRequestDto.class));
//    }
//
//    @Bean
//    RouterFunction<ServerResponse> postTest() {
////        return route(POST("/kafka"),
////                req ->
////                        req.bodyToMono(KafkaMessageRequestDto.class)
////                                .doOnNext(kafkaProducer::sendMessage)
////                                .then(ok().body(Mono.just(new KafkaMessageRequestDto("포스트")), KafkaMessageRequestDto.class))
////        );
//        KafkaHandler handler = new KafkaHandler(kafkaProducer);
//        return route(POST("/kafka"),handler::kafkaTest);
//    }

}
