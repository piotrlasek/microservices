package com.piotrlasek.customer.service;

import com.piotrlasek.customer.connector.AccountsConnector;
import com.piotrlasek.customer.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {
    private final AccountsConnector accountsConnector;

    public List<AccountDto> getCustomerAccounts(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                        account.getId(),
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFunds()
                )).collect(Collectors.toList());
    }

}
