package com.springmicroservice.target.price.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
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

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(Long priceId, String currencyCode, float priceValue) {
		super();
		this.priceId = priceId;
		this.currencyCode = currencyCode;
		this.priceValue = priceValue;
	}

	private String currencyCode;
	private float priceValue;

}
