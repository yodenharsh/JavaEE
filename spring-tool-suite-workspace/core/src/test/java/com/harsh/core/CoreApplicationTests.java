package com.harsh.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.harsh.core.services.PaymentServiceImpl;

@SpringBootTest
class CoreApplicationTests {

	PaymentServiceImpl service;
	
	@Test
	public void testDependencyInjection() {
		assertNotNull(service.getDao());
	}

}
