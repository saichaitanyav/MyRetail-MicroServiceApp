package com.springmicroservice.target.product.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservice.target.product.VO.ProductPriceVO;
import com.springmicroservice.target.product.entity.Product;
import com.springmicroservice.target.product.exception.ProductNotFoundException;
import com.springmicroservice.target.product.sevice.ProductService;

import lombok.extern.slf4j.Slf4j;

//import jdk.internal.org.jline.utils.Log;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/**
	 * Create Product
	 * @param product
	 * @return product created
	 * @throws SQLException
	 */
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) throws SQLException, Exception {
		//log.info("Inside save Product method");
		return productService.saveProduct(product);
	}
	
	/**
	 * Retrieve Product with productId
	 * @param productId
	 * @return
	 * @throws ProductNotFoundException
	 */
	@GetMapping("/product/{productId}")
	public Product retrieveProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return productService.findProductById(productId);
	}
	
	/**
	 * Retrieve Product with Price with productId
	 * @param productId
	 * @return
	 * @throws ProductNotFoundException
	 */
	@GetMapping("/{productId}")
	public ProductPriceVO getProductWithPrice(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return productService.getProductWithPrice(productId);
	}
}
