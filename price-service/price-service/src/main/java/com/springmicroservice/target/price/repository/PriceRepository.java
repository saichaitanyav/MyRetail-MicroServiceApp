package com.springmicroservice.target.price.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springmicroservice.target.price.entity.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long>{
	 Price findByPriceId(Long priceId);
}
