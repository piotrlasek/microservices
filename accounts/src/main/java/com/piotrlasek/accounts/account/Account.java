package com.piotrlasek.accounts.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="accounts")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column
    private String nrb;

    @Column(name="available_funds")
    private BigDecimal availableFunds;
    
    @Column
    private String currency;
}