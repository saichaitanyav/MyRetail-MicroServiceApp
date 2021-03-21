package com.springmicroservice.target.product.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceVO {

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
