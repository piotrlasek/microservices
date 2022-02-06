package com.piotrlasek.cards.components;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
public class CardDto {
    String number;
    LocalDate validUntil;
}
