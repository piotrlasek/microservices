package com.piotrlasek.customer.service;

import com.piotrlasek.customer.domain.Customer;
import com.piotrlasek.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(Long id) {
        Customer customer = customerRepository.findCustomerByCustomerId(id);
        Optional<Customer> optionalCustomer = Optional.ofNullable(customer);
        return optionalCustomer;
    }
}
