package com.springmicroservice.target.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.springmicroservice.target.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	  Product findByProductId(Long Id);
}
