package com.springmicroservice.target.product.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springmicroservice.target.product.VO.Price;
import com.springmicroservice.target.product.VO.ProductPriceVO;
import com.springmicroservice.target.product.exception.ProductNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProductController.class })
public class ProductControllerTest {

	@MockBean
	ProductController productController;

	@BeforeEach
	public void setup() throws ProductNotFoundException {
		Price  priceDetail = new Price((long)1234, "USD", (float)(12.34));
		ProductPriceVO vo = new ProductPriceVO((long) 13860428, "The Big Lebowski (Blu-ray)", priceDetail);
		when(productController.getProductWithPrice((long) 13860428)).thenReturn(vo);
	}

	@Test
	public void testProductNameMatches() throws ProductNotFoundException {
		ProductPriceVO actual = productController.getProductWithPrice((long) 13860428);
		assertTrue(actual.getName().equals("The Big Lebowski (Blu-ray)"));
	}
	
	@Test
	public void testProductNotExists() throws ProductNotFoundException {
		ProductPriceVO actual = productController.getProductWithPrice((long) 78989565);
		assertNull(actual);
	}
}
