package com.piotrlasek.customer.dto;

import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    String number;
    LocalDate validUntil;
}
