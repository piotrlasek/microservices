package com.example.transfersrealizationservice.service;

import com.example.transfersrealizationservice.repository.Transfer;
import com.example.transfersrealizationservice.repository.TransferRepository;
import com.kodilla.commons.TransferMessage;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class TransferListener {

    @Autowired
    TransferRepository transferRepository;
    @Autowired
    BalanceUpdater balanceUpdater;

    @KafkaListener(topics = "micro-transfers")
    @Payload
    @Transactional
    public void consume(@Payload List<TransferMessage> transferMessages) throws IOException {
       log.info("Consumed tranferMessage: {}", transferMessages);

       TransferMessage transferMessage = transferMessages.get(0);

       // saving transfer to db

        Transfer transfer = new Transfer();
        transfer.setNrbFrom(transferMessage.getTransfer().getSenderAccount());
        transfer.setNrbTo(transferMessage.getTransfer().getRecipientAccount());
        transfer.setAmount(transferMessage.getTransfer().getAmount());

        transferRepository.insertTransfer(transfer);

        // insert balances to kafka micro-balance
        balanceUpdater.insert(transferMessages.get(0));
    }
}
