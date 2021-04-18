package com.springmicroservice.target.price.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
@SpringBootTest(classes = { PriceService.class })
public class PriceServiceTest {
	@MockBean
	PriceService priceService;

	@BeforeEach
	public void setup() throws PriceNotFoundException {
		Price  priceDetail = new Price((long)1234, "USD", (float)(12.34));
		when(priceService.getPrice((long) 1234)).thenReturn(priceDetail);
	}

	
	@Test
	public void testPriceExists() throws PriceNotFoundException {
		Price price = priceService.getPrice((long) 1234);
		assertNotNull(price);
	}

	@Test
	public void testPriceNotExists() throws PriceNotFoundException {
		Price price = priceService.getPrice((long) 2586);
		assertNull(price);
	}

}
