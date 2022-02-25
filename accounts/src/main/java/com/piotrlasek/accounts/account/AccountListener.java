package com.piotrlasek.accounts.account;

import com.kodilla.commons.Transfer;
import com.kodilla.commons.TransferMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountListener {

    @Autowired
    AccountsRepository accountsRepository;

    @KafkaListener(topics = "micro-balance")
    @Payload
    @Transactional
    public void consume(@Payload TransferMessage transferMessage) {
        log.info("Consuming balance-transfer topic");

        Transfer transfer = transferMessage.getTransfer();
        String nrbFrom = transfer.getSenderAccount();
        String nrbTo = transfer.getRecipientAccount();
        BigDecimal amount = transfer.getAmount();

        log.info("Transfer: {}", transfer);

        accountsRepository.updateAmount(nrbFrom, BigDecimal.ZERO.subtract(amount));

        accountsRepository.updateAmount(nrbTo, amount);

        log.info("done");
    }
}
