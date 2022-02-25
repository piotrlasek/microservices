package com.piotrlasek.accounts.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    public List<Account> findAccountsByCustomerId(Long customerId) {
        List<Account> accounts = accountsRepository.findAccountsByCustomerId(customerId);
        return accounts;
    }

    public BigDecimal findFundsByNrb(String nrb) {
        Account account = accountsRepository.findFundsByNrb(nrb);
        return account.getAvailableFunds();
    }

    public void transfer(String nrb, BigDecimal amount) {
        Account account = accountsRepository.findFundsByNrb(nrb);
        accountsRepository.updateAmount(nrb, account.getAvailableFunds().add(amount));
    }
}