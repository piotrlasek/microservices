package com.example.transfersgateway.controller;

import com.example.transfersgateway.service.AccountsProvider;
import com.example.transfersgateway.service.TransferProducer;
import com.kodilla.commons.Transfer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/v1/micro-transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferProducer transferProducer;
    private final AccountsProvider accountsProvider;

    @PostMapping
    public void saveTransfer(@RequestBody TransferRequest request) {
        log.info("Received tranfer request: {}", request);

        String nrb = request.getSenderAccount();
        BigDecimal availableFunds = accountsProvider.getFundsByNrb(nrb);

        // check if funds are sufficient
        if (availableFunds.compareTo(request.getAmount()) >= 0) {
            log.info("Funds are sufficient.");

            Transfer transfer = new Transfer();
            transfer.setAmount(request.getAmount());
            transfer.setRecipientAccount(request.getRecipientAccount());
            transfer.setSenderAccount(request.getSenderAccount());
            transfer.setTitle(request.getTitle());

            transferProducer.sendTransfer(transfer);
        } else {
            log.info("Available funds are not sufficient!!!");
        }
    }
}
