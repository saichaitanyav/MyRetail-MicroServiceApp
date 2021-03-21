package com.springmicroservice.target.product.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springmicroservice.target.product.VO.Price;
import com.springmicroservice.target.product.VO.RestTemplateVO;
import com.springmicroservice.target.product.entity.Product;
import com.springmicroservice.target.product.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findProductById(Long productId) {
		return productRepository.findByProductId(productId);
	}

	public RestTemplateVO getProductWithPrice(Long productId) {
		RestTemplateVO productPrice = new RestTemplateVO();
		Product product = productRepository.findByProductId(productId);
		String uri = "http://PRICE-SERVICE/price/";
		Price price = restTemplate.getForObject(uri+product.getPriceId(), Price.class);
		productPrice.setProduct(product);
		productPrice.setPrice(price);
		return productPrice;
	}

}
