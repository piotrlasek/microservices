package com.piotrlasek.customer.connector.response;

import com.piotrlasek.customer.dto.AccountDto;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {
    private List<AccountDto> accounts;
}
