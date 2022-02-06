package com.piotrlasek.accounts.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@RestController
@RequestMapping(value="/v1")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @Value("${accounts.allow-get-accounts}")
    private boolean allowGetAccounts;

    @GetMapping(value = "/accounts")
    @ResponseBody
    public GetAccountsResponse findAccountsByCustomerId(@RequestParam(value="customerId") String customerId) {
        log.info("Getting accounts for customerId: {}", customerId);

        if (!allowGetAccounts) {
            log.info("Getting accounts is disabled!");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

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