package com.piotrlasek.accounts;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class AccountsApplicationTests {

	@Test
	void contextLoads() {
		assertEquals(1, 1);
	}

}
