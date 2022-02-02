package com.piotrlasek.accounts.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer> {

    @Query("select a from accounts a where customer_id=(:customerId)")
    public List<Account> findAccountsByCustomerId(@Param("customerId") Long customerId);

    public List<Account> findByCustomerId(@Param("customerId") Long customerId);
}