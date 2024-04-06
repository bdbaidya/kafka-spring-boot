package com.learning.kafka.apache.kafka;

import com.learning.kafka.apache.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    private static final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void jsonConsumer(User user){
        logger.info(String.format("JSON Message received -> %s", user.toString()));
    }
}