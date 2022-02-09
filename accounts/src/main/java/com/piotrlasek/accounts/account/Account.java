package com.piotrlasek.accounts.account;

import lombok.*;

import javax.persistence.*;

@Entity(name="accounts")
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column
    private String nrb;

    @Column(name="available_funds")
    private Float availableFunds;
    
    @Column
    private String currency;
}