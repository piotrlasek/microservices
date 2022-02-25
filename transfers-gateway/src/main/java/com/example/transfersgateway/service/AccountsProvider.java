package com.example.transfersgateway.service;

import com.example.transfersgateway.connectors.AccountsConnector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountsProvider {

    @Autowired
    AccountsConnector accountsConnector;

    public BigDecimal getFundsByNrb(String nrb) {

        BigDecimal availableFunds = BigDecimal.ZERO;

        try {
            availableFunds = accountsConnector.findFundsByNrb(nrb).getFunds();
        } catch (Exception e) {
            log.error(e.toString());
        }

        return availableFunds;
    }
}
