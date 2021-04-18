package com.springmicroservice.target.price.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicroservice.target.price.entity.Price;
import com.springmicroservice.target.price.exception.PriceNotFoundException;
import com.springmicroservice.target.price.repository.PriceRepository;

@Service
public class PriceService {
	
@Autowired	
PriceRepository priceRepository;

public Price savePrice(Price price) throws SQLException{
	return priceRepository.save(price);
}

public Price getPrice(Long priceId) {
	Price price = priceRepository.findByPriceId(priceId);
	if(null == price) {
		throw new PriceNotFoundException("Price not found" + priceId);
	}
	return priceRepository.findByPriceId(priceId);
}
}
