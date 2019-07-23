package com.sk.sample.park.product.domain.model;

import javax.persistence.Entity;

import com.sk.sample.park.shared.base.AbstractEntity;
import com.sk.sample.park.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Product extends AbstractEntity implements AggregateRoot {
	private String name;
	private Money price;
	
	private ProductDescription productDescription;
	
	public Product(String name, Money price, ProductDescription productDescription) {
		this.name = name;
		this.price = price;
		this.productDescription = productDescription;
	}
}

