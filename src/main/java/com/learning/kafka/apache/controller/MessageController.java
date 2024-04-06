package com.learning.kafka.apache.controller;

import com.learning.kafka.apache.kafka.JsonProducer;
import com.learning.kafka.apache.kafka.KafkaProducer;
import com.learning.kafka.apache.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;
    private JsonProducer jsonProducer;
    public MessageController(KafkaProducer kafkaProducer , JsonProducer jsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish_kafka(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka.");

    }


    //For sending JSON Data
    @RequestMapping("/json-publish")
    public ResponseEntity<String > publishJson(@RequestBody User user){
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message Sent to Kafka");
    }

}
