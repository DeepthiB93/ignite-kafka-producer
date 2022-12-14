package com.ignite.tweetsvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaProducer {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
    }
}
