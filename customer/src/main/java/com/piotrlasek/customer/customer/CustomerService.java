package com.piotrlasek.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {
        Customer c = customerRepository.findCustomerByCustomerId(id);
        return c;
    }
}
