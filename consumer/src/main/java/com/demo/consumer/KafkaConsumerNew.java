package com.demo.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumerNew {

    @Bean
    public Consumer<Message<RiderLocation>> processRiderLocation() {
        return message -> {
            RiderLocation location = message.getPayload();
            Object partition = message.getHeaders().get("kafka_receivedPartitionId");
            System.out.println("Received Rider Location: " + location.getId()
                                       + " @ " + location.getLatitude() + ", " + location.getLongitude()
                                       + " | Partition: " + partition);
        };
    }

    @Bean
    public Consumer<String> processRiderStatus() {
        return status -> {
            System.out.println("Received Rider Status: " + status);
        };
    }
}
