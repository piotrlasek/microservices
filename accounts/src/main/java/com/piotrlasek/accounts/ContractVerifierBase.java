package com.piotrlasek.accounts;

import com.netflix.discovery.converters.Auto;
import com.piotrlasek.accounts.account.Account;
import com.piotrlasek.accounts.account.AccountsController;
import com.piotrlasek.accounts.account.AccountsRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.Collections;

import static org.mockito.Mockito.when;

@Ignore
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AccountsRepository repository;


    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(context);

        when(repository.findAccountsByCustomerId(1L)).thenReturn(
            Collections.singletonList(
                Account.builder()
                    .id(95213L)
                    .nrb("08897810189710581776778244")
                    .currency("PLN")
                    .customerId(1L)
                    .build()
                )
        );
    }

}
