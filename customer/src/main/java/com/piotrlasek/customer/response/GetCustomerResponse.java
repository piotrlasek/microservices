package com.piotrlasek.customer.response;

import com.piotrlasek.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetCustomerResponse {
    CustomerDto customerDto;
}
