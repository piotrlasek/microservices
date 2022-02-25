package com.example.transfersrealizationservice.repository;

import io.micrometer.core.annotation.Counted;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="transfer")
@Getter
@Setter
@NoArgsConstructor
public class Transfer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "nrb_from")
    String nrbFrom;

    @Column(name = "nrb_to")
    String nrbTo;

    @Column(name = "amount")
    BigDecimal amount;
}
