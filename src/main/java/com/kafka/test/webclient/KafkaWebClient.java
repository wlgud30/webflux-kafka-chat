package com.kafka.test.webclient;

import com.kafka.test.dto.kafka.KafkaMessageRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
public class KafkaWebClient {

    WebClient client = WebClient.create("http://localhost:8080");

    public void consume() {

        Mono<ResponseEntity<KafkaMessageRequestDto>> kafkaTestMono = client.post()
                .uri("/kafka")
                .retrieve()
                .toEntity(KafkaMessageRequestDto.class);

        kafkaTestMono.subscribe(kafkaDto -> log.debug("Employee: {}", kafkaDto));

        Mono<ResponseEntity<KafkaMessageRequestDto>> testMono = client.get()
                .uri("/kafka")
                .retrieve()
                .toEntity(KafkaMessageRequestDto.class);

        testMono.subscribe(r->log.info("test11"));
//
//        Flux<Employee> employeeFlux = client.get()
//                .uri("/employees")
//                .retrieve()
//                .bodyToFlux(Employee.class);
//
//        employeeFlux.subscribe(employee -> LOGGER.debug("Employee: {}", employee));
    }

}
