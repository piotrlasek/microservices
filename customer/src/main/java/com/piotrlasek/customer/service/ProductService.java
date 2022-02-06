package com.piotrlasek.customer.service;

import com.piotrlasek.customer.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final AccountsProvider accountsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountsProvider.getCustomerAccounts(customerId);
    }
}
