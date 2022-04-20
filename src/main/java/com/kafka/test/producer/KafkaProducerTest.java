package com.kafka.test.producer;

import com.kafka.test.dto.kafka.KafkaMessageRequestDto;
import com.kafka.test.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerTest {

    private static final String TOPIC = "test_topic";

    private final KafkaTemplate<String, Message> kafkaChatTemplate;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(Message data){
        log.info("Producer message : "+data);
        try {
            kafkaChatTemplate.send(TOPIC,"chat_msg",data).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        log.info("producer string message : " + msg);
        kafkaTemplate.send(TOPIC,"string_msg",msg);
    }

}
