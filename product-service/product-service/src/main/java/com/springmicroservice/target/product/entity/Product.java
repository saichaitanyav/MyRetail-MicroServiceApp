package com.springmicroservice.target.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Product {
	@Id
	private Long productId;

	private Long priceId;

	public Long getProductId() {
		return productId;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, Long priceId, String name) {
		super();
		this.productId = productId;
		this.priceId = priceId;
		this.name = name;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

}
