package com.kafka.test.consumer;

import com.kafka.test.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerTest {

    SimpMessagingTemplate template;

    @KafkaListener(topics = "test_topic",groupId = "ji")
    public void listen(String msg){
        log.info("Consumed message : " + msg);
    }

    @KafkaListener(topics = "test_topic",groupId = "ji")
    public void listen(Message msg){
        log.info("Consumed message : " + msg);
        template.convertAndSend("/topic/group",msg);
    }



}
