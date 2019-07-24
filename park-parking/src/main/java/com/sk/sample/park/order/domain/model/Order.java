package com.sk.sample.park.order.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sk.sample.park.shared.base.AbstractEntity;
import com.sk.sample.park.shared.base.AggregateRoot;
import com.sk.sample.park.shared.domain.Address;

import lombok.Data;

@Data
@Entity
@Table(name = "ordering")
public class Order extends AbstractEntity implements AggregateRoot {
	private Long buyerAccountId;
	private Long productId;
	private Integer productCount;
		
	private CreditCard creditCard;
	private Address shippingAddress;
	
	private Integer totalPrice;
	private Boolean purchased = false;
	
	public Order(Long buyerAccountId, Long productId, Integer productCount) {
		this.buyerAccountId = buyerAccountId;
		this.productId = productId;
		this.productCount = productCount;
	}
}
