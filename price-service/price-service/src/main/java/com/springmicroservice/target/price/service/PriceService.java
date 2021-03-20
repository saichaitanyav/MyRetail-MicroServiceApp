package com.springmicroservice.target.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmicroservice.target.price.entity.Price;
import com.springmicroservice.target.price.repository.PriceRepository;

@Service
public class PriceService {
	
@Autowired	
PriceRepository priceRepository;

public Price savePrice(Price price) {
	return priceRepository.save(price);
}

public Price getPrice(Long priceId) {
	return priceRepository.findByPriceId(priceId);
}
}
