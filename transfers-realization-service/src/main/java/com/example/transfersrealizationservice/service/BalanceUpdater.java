package com.example.transfersrealizationservice.service;

import com.kodilla.commons.Transfer;
import com.kodilla.commons.TransferMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BalanceUpdater {

    private static final String BALANCE_TOPIC = "micro-balance";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void insert(final TransferMessage transferMessage) {
        log.info("Sending message to Kafka / balance, transferMessage: {}", transferMessage);
        kafkaTemplate.send(BALANCE_TOPIC, transferMessage);
        log.info("Message was sent.");
    }
}
