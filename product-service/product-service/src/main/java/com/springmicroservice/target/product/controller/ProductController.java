package com.springmicroservice.target.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservice.target.product.VO.RestTemplateVO;
import com.springmicroservice.target.product.entity.Product;
import com.springmicroservice.target.product.sevice.ProductService;

import lombok.extern.slf4j.Slf4j;

//import jdk.internal.org.jline.utils.Log;


@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		//Log.info("Inside save Produt method");
		return productService.saveProduct(product);
	}
	
	@GetMapping("/product/{productId}")
	public Product retrieveProduct(@PathVariable("productId") Long productId) {
		return productService.findProductById(productId);
	}
	
	@GetMapping("/{productId}")
	public RestTemplateVO getProductWithPrice(@PathVariable("productId") Long productId) {
		return productService.getProductWithPrice(productId);
	}
}
