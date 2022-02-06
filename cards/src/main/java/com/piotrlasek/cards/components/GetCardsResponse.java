package com.piotrlasek.cards.components;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public class GetCardsResponse {
    List<CardDto> cards;
}
