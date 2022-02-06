package com.piotrlasek.customer.service;

import com.piotrlasek.customer.connector.AccountsConnector;
import com.piotrlasek.customer.connector.CardsConnector;
import com.piotrlasek.customer.connector.response.GetCardsResponse;
import com.piotrlasek.customer.dto.AccountDto;
import com.piotrlasek.customer.dto.CardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {
    private final CardsConnector cardsConnector;

    // @HystrixCommand(fallbackMethod = "fallbackGetAccounts")
    public List<CardDto> getCustomerCards(Long customerId) {
        return cardsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(card -> new CardDto(
                        card.getNumber(),
                        card.getValidUntil()
                )).collect(Collectors.toList());
    }

}
