package com.piotrlasek.accounts.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class AccountDTO {
    private Long id;

    private String nrb;

    private String currency;

    private Float availableFunds;
}
