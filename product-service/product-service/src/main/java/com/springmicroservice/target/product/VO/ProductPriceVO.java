package com.springmicroservice.target.product.VO;

import lombok.Data;

@Data
public class ProductPriceVO {

	public ProductPriceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductPriceVO(Long id, String name, Price current_price) {
		super();
		Id = id;
		Name = name;
		this.current_price = current_price;
	}
	private Long Id;
	private String Name;
	private Price current_price;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Price getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(Price current_price) {
		this.current_price = current_price;
	}

}
