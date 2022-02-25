package com.example.transfersrealizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
public class TransfersRealizationServiceApplication {

	@KafkaListener(topics = "micro-transfers")
	public static void main(String[] args) {
		SpringApplication.run(TransfersRealizationServiceApplication.class, args);
	}

}
