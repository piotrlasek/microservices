package com.example.transfersgateway.connectors;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "accounts")
public interface AccountsConnector {
    @GetMapping("/v1/funds")
    GetFundsResponse findFundsByNrb(@RequestParam("nrb") String nrb);
}
