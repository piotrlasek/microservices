package com.piotrlasek.accounts.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class AccountDto {
    private Long id;

    private String nrb;

    private String currency;

    private BigDecimal availableFunds;
}
