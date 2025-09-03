package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {
    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {
        Random random = new Random();
        return () -> {
            String id = "rider" + random.nextInt(30);
            RiderLocation location = new RiderLocation(id, 16.7, 88.1);
            System.out.println("Sending Rider location: " + location.getId());
            return location;
        };
    }

    @Bean
    public Supplier<String> sendRiderStatus() {
        Random random = new Random();
        return () -> {
            String[] statuses = {"AVAILABLE", "BUSY", "OFFLINE"};
            String randomStatus = statuses[random.nextInt(statuses.length)];
            System.out.println("Sending Rider Status: " + randomStatus);
            return randomStatus;
        };
    }
}
