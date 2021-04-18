package com.springmicroservice.target.price.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservice.target.price.entity.Price;
import com.springmicroservice.target.price.exception.PriceNotFoundException;
import com.springmicroservice.target.price.service.PriceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/price")
@Slf4j
public class PriceController {

	@Autowired
	private PriceService priceService;

	@PostMapping("/")
	public Price savePrice(@RequestBody Price price) throws SQLException {
		return priceService.savePrice(price);
	}

	@GetMapping("/{id}")
	public Price getPriceById(@PathVariable("id") Long priceId) throws PriceNotFoundException {
		return priceService.getPrice(priceId);
	}
}
