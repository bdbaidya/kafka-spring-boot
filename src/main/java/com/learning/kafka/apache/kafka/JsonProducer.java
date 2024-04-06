package com.learning.kafka.apache.kafka;

import com.learning.kafka.apache.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {
    private static final Logger logger = LoggerFactory.getLogger(JsonProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;
    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {

        logger.info(String.format("JSON Message sent -> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "test-json")
                .build();

        kafkaTemplate.send(message);
    }
}
