package com.springmicroservice.target.product.VO;

import lombok.Data;

@Data
public class Price {
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

	private Long priceId;
	private String currencyCode;
	private float priceValue;
}
