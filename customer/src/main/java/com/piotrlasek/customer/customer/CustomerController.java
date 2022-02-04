package com.piotrlasek.customer.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
@RefreshScope
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-customer}")
    private boolean allowGetCustomer;

    @Autowired
    CustomerService customerService;

    @GetMapping(value="/{idCustomer}")
    public GetCustomerResponse getCustomerById(@PathVariable(value="idCustomer") Long idCustomer) {

        if (!allowGetCustomer) {
            log.info("Getting customer info is disabled.");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        Customer customer = customerService.getCustomerById(idCustomer);

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());

        GetCustomerResponse response = GetCustomerResponse.of(customerDto);
        
        return response;
    }
}
