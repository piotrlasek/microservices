package com.piotrlasek.customer.connector;

import com.piotrlasek.customer.connector.response.GetCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardsConnector {
    @GetMapping("/v1/cards")
    GetCardsResponse getCards(@RequestParam("customerId") Long customerId);
}

@Component
@Slf4j
class CardsConnectorFallback implements CardsConnector {
    @Override
    public GetCardsResponse getCards(Long customerId) {
        return GetCardsResponse.of(Collections.emptyList());
    }
}
