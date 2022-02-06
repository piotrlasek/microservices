package com.piotrlasek.customer.response;

import com.piotrlasek.customer.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCustomerProductResponse {
    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;
}
