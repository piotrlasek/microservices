package com.piotrlasek.customer.connector.response;

import com.piotrlasek.customer.dto.AccountDto;
import com.piotrlasek.customer.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetAccountsResponse {
    private List<AccountDto> accounts;
}
