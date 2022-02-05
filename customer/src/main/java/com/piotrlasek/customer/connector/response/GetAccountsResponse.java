package com.piotrlasek.customer.connector.response;

import lombok.Data;
import java.util.List;

@Data
public class GetAccountsResponse {
    private List<AccountDto> accounts;
}
