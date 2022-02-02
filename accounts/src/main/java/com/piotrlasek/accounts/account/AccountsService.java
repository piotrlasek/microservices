package com.piotrlasek.accounts.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    public List<Account> findAccountsByCustomerId(Long customerId) {
        List<Account> accounts = accountsRepository.findAccountsByCustomerId(customerId);
        return accounts;
    }
}