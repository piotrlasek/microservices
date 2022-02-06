package com.piotrlasek.cards.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardsService {

    @Autowired
    CardsRepository cardsRepository;

    List<CardDto> getCardsByCustomerId(Long customerId) {
        List<Card> cards = cardsRepository.findByCustomerId(customerId);

        return cards.stream()
                .map(CardsService::convert)
                .collect(Collectors.toList());
    }

    private static CardDto convert(Card card) {
        CardDto cardDto = CardDto.builder()
                .number(card.getNumber())
                .validUntil(card.getValidUntil())
                .build();
        return cardDto;
    }

}
