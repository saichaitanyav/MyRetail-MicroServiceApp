package com.springmicroservice.target.product.sevice;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springmicroservice.target.product.VO.Price;
import com.springmicroservice.target.product.VO.ProductPriceVO;
import com.springmicroservice.target.product.entity.Product;
import com.springmicroservice.target.product.exception.ProductNotFoundException;
import com.springmicroservice.target.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) throws SQLException {
		return productRepository.save(product);
	}

	public Product findProductById(Long productId) {
		Product product = productRepository.findByProductId(productId);
		if (null == product) {
			throw new ProductNotFoundException("Product not found" + productId);
		}
		return product;
	}

	public ProductPriceVO getProductWithPrice(Long productId) {
		ProductPriceVO productPrice = new ProductPriceVO();
		Product product = productRepository.findByProductId(productId);
		if (null == product) {
			throw new ProductNotFoundException("Product not found" + productId);
		}
		String uri = "http://PRICE-SERVICE/price/";
		Price price = restTemplate.getForObject(uri + product.getPriceId(), Price.class);
		if (null == price) {
			throw new ProductNotFoundException("Price not found" + product.getPriceId());
		}
		productPrice.setId(product.getProductId());
		productPrice.setName(product.getName());
		productPrice.setCurrent_price(price);
		return productPrice;
	}

}
