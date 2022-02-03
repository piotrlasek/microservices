package com.piotrlasek.accounts.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/v1")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping(value = "/accounts")
    @ResponseBody
    public GetAccountsResponse findAccountsByCustomerId(@RequestParam(value="customerId") String customerId) {
        List<Account> accounts =  accountsService.findAccountsByCustomerId(Long.parseLong(customerId));
        List<AccountDto> accountDtos = toDTOs(accounts);
        GetAccountsResponse response = GetAccountsResponse.of(accountDtos);
        return response;
    }

    public List<AccountDto> toDTOs(List<Account> accounts) {
        return accounts.stream().map (
                account -> {
                    AccountDto aDTO = new AccountDto();
                    aDTO.setId(account.getId());
                    aDTO.setCurrency(account.getCurrency());
                    aDTO.setAvailableFunds(account.getAvailableFunds());
                    aDTO.setNrb(account.getNrb());
                    return aDTO;
                }
        ).collect(Collectors.toList());
    }
}