package com.piotrlasek.customer.service;

import com.piotrlasek.customer.dto.AccountDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.piotrlasek:accounts:+:stubs:9000"
        }
)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findCustomerAccounts() {
        // Given
        Long customerId = 1L;

        // When
        List<AccountDto> accountDtos = productService.findCustomerAccounts(customerId);

        // Then
        assertEquals(1, accountDtos.size());
    }

    // Additional test
    @Test
    void verifyAccountNrbAndCurrency() {
        // Given
        Long customerId = 1L;

        // When
        List<AccountDto> accountDtos = productService.findCustomerAccounts(customerId);

        // Then
        AccountDto account = accountDtos.get(0);

        assertEquals("08897810189710581776778244", account.getNrb());
        assertEquals("PLN", account.getCurrency());
    }
}