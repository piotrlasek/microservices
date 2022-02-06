package com.piotrlasek.customer.controller;

import com.piotrlasek.customer.domain.Customer;
import com.piotrlasek.customer.dto.AccountDto;
import com.piotrlasek.customer.dto.CardDto;
import com.piotrlasek.customer.dto.CustomerDto;
import com.piotrlasek.customer.response.GetCustomerProductResponse;
import com.piotrlasek.customer.response.GetCustomerResponse;
import com.piotrlasek.customer.service.CustomerService;
import com.piotrlasek.customer.service.ProductService;
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

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RefreshScope
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-customer}")
    private boolean allowGetCustomer;

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

    @GetMapping(value="/{idCustomer}")
    public GetCustomerResponse getCustomerById(@PathVariable(value="idCustomer") Long idCustomer) {
        if (!allowGetCustomer) {
            log.info("Getting customer info is disabled.");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        Customer customer = customerService.getCustomerById(idCustomer).get();

        CustomerDto customerDto = CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();

        GetCustomerResponse response = GetCustomerResponse.of(customerDto);

        return response;
    }

    @GetMapping(value="/{customerId}/products")
    public GetCustomerProductResponse getCustomerProducts(@PathVariable Long customerId) {


        log.info("Getting customer {} products.", customerId);

        Customer customer =
                customerService.getCustomerById(customerId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);
        List<CardDto> customerCards = productService.findCustomerCards(customerId);

        return GetCustomerProductResponse.builder()
                .customerId(customer.getId())
                .accounts(customerAccounts)
                .cards(customerCards)
                .fullName(customer.getFirstName() + " " + customer.getLastName())
                .build();
    }
}
