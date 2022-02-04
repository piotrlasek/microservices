package com.piotrlasek.customer.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from customer c where id=(:customerId)")
    public Customer findCustomerByCustomerId(Long customerId);

}
