package com.springmicroservice.target.price.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Price {

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public float getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(float priceValue) {
		this.priceValue = priceValue;
	}

	@Id
	private Long priceId;
	private String currencyCode;
	private float priceValue;

}