package com.springmicroservice.target.price.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springmicroservice.target.price.entity.Price;
import com.springmicroservice.target.price.exception.PriceNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PriceController.class })
public class PriceControllerTest {

	@MockBean
	PriceController priceController;

	@BeforeEach
	public void setup() throws PriceNotFoundException {
		Price  priceDetail = new Price((long)1234, "USD", (float)(12.34));
		when(priceController.getPriceById((long) 1234)).thenReturn(priceDetail);
	}

	@Test
	public void testPriceExists() throws PriceNotFoundException {
		Price  actual = priceController.getPriceById((long) 1234);
		assertNotNull(actual.getPriceValue());
	}
	
	@Test
	public void testPriceNotExists() throws PriceNotFoundException {
		Price  actual = priceController.getPriceById((long) 129034);
		assertNull(actual);
	}
}
