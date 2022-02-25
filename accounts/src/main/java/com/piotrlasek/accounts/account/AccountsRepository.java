package com.piotrlasek.accounts.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer> {

    @Query("select a from accounts a where customer_id=(:customerId)")
    public List<Account> findAccountsByCustomerId(@Param("customerId") Long customerId);

    @Query("select a from accounts a where nrb like (:nrb)")
    public Account findFundsByNrb(@Param("nrb") String nrb);

    @Query("update accounts a set available_funds = available_funds + (:amount) where nrb like (:nrb)")
    @Modifying
    public void updateAmount(@Param("nrb") String nrb, @Param("amount") BigDecimal amount);
}