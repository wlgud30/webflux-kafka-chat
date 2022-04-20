package com.kafka.test.handler;

import com.kafka.test.dto.kafka.KafkaMessageRequestDto;
import com.kafka.test.model.Message;
import com.kafka.test.producer.KafkaProducerTest;
import com.kafka.test.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaHandler {

    private final KafkaProducerTest kafkaProducer;

    public Mono<ServerResponse> kafkaTest(ServerRequest request){
        Mono<KafkaMessageRequestDto> dto = request.bodyToMono(KafkaMessageRequestDto.class);
        return dto.flatMap(r->{
            kafkaProducer.sendMessage(r.getMsg());
            return ok().contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(r),KafkaMessageRequestDto.class);
        });
    }

    public Mono<ServerResponse> kafkaChat(ServerRequest request){
        Mono<Message> msg = request.bodyToMono(Message.class);
        return msg.flatMap(r->{
            r.setTimestamp(LocalDateTime.now().toString());
            kafkaProducer.sendMessage(r);
            return ok().contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(new ResponseDto(0,HttpStatus.OK,"메세지를 전송합니다.")),ResponseDto.class);
        });
    }
}
