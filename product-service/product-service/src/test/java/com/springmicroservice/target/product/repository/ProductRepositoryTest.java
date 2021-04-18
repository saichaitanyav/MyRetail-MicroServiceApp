package com.springmicroservice.target.product.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springmicroservice.target.product.entity.Product;
import com.springmicroservice.target.product.exception.ProductNotFoundException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProductRepository.class })
public class ProductRepositoryTest {
	@MockBean
	private ProductRepository mockProductRepository;

	@BeforeEach
	public void setUp() {
		Product product = new Product((long) 13860428, (long) 34356565, "The Big Lebowski (Blu-ray)");
		when(mockProductRepository.findByProductId((long) 13860428)).thenReturn(product);
	}

	@Test
	public void testProductByIdFound() throws ProductNotFoundException {
		Product product = mockProductRepository.findByProductId((long) 13860428);
		assertNotNull(product);

	}

	@Test
	public void testProductByIdNotFound() throws ProductNotFoundException {
		Product product = mockProductRepository.findByProductId((long) 123111118);
		assertNull(product);
	}

	@Test
	public void testProductByIdMatchesFound() throws ProductNotFoundException {
		Product product = mockProductRepository.findByProductId((long) 13860428);
		assertNotEquals(13860428, product.getProductId());

	}

	@Test
	public void testProductByIdMatchesNotFound() throws ProductNotFoundException {
		Product product = mockProductRepository.findByProductId((long) 13860428);
		assertNotEquals(138604281, product.getProductId());

	}
}
