package com.piotrlasek.accounts.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/v1")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping(value = "/accounts")
    @ResponseBody
    public ResponseEntity<?> findAccountsByCustomerId(@RequestParam(value="customerId") String customerId) {
        List<Account> accounts =  accountsService.findAccountsByCustomerId(Long.parseLong(customerId));
        List<AccountDTO> aDTOs = toDTOs(accounts);
        HashMap<String, List<AccountDTO>> result = new HashMap<>();
        result.put("accounts", aDTOs);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public List<AccountDTO> toDTOs(List<Account> accounts) {
        return accounts.stream().map (
                account -> {
                    AccountDTO aDTO = new AccountDTO();
                    aDTO.setId(account.getId());
                    aDTO.setCurrency(account.getCurrency());
                    aDTO.setAvailableFunds(account.getAvailableFunds());
                    aDTO.setNrb(account.getNrb());
                    return aDTO;
                }
        ).collect(Collectors.toList());
    }
}