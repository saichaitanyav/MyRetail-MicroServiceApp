package com.springmicroservice.target.product.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springmicroservice.target.product.entity.Product;
import com.springmicroservice.target.product.exception.ProductNotFoundException;
import com.springmicroservice.target.product.sevice.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProductService.class })
public class ProductServiceTest {
	@MockBean
	ProductService productService;

	@BeforeEach
	public void setup() throws ProductNotFoundException {
		Product  product = new Product((long) 13860428, (long) 34356565,  "The Big Lebowski (Blu-ray)");
		when(productService.findProductById((long) 13860428)).thenReturn(product);
	}
	
	@Test
	public void testProductExists() throws ProductNotFoundException {
		Product product = productService.findProductById((long) 13860428);
		assertNotNull(product);
		assertTrue("The Big Lebowski (Blu-ray)".equalsIgnoreCase(product.getName()));
	}

	@Test
	public void testProductNameNotMatch() throws ProductNotFoundException {
		Product product = productService.findProductById((long) 13860428);
		assertFalse("NameNotmatch".equalsIgnoreCase(product.getName()));
	}
	
	@Test
	public void testProductNotExists() throws ProductNotFoundException {
		Product product = productService.findProductById((long) 138628);
		assertNull(product);
	}
}
