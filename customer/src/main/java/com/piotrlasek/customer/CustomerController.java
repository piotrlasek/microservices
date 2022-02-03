package com.piotrlasek.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="/{idCustomer}")
    public GetCustomerResponse getCustomerById(@PathVariable(value="idCustomer") Long idCustomer) {
        Customer customer = customerService.getCustomerById(idCustomer);

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());

        GetCustomerResponse response = GetCustomerResponse.of(customerDto);


        return response;
    }
}
