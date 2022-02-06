package com.piotrlasek.cards.components;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Card {
    @Id
    Long id;

    @Column(name = "customer_id")
    Long customerId;

    @Column
    String number;

    @Column(name = "valid_until")
    LocalDate validUntil;

}
