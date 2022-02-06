package com.piotrlasek.cards.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    CardsService cardsService;

    @GetMapping("v1/cards")
    GetCardsResponse getCards(@RequestParam("customerId") Long customerId) {
        List<CardDto> cardsDtos = cardsService.getCardsByCustomerId(customerId);
        GetCardsResponse response = GetCardsResponse.of(cardsDtos);
        return response;
    }
}
