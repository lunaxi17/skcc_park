package com.sk.sample.park.parking.application.proxy.feign.dto.payment;

import com.sk.sample.park.parking.application.proxy.feign.dto.parkinglot.Parkinglot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Credit {
	private CreditCard creditCard;
	private Integer usedAmount;
	private Integer limitAmount;
	
	public Credit(CreditCard creditCard) {
		this.creditCard = creditCard;
		this.usedAmount = 0;
		this.limitAmount = 1000000;
	}
	
	public Credit(CreditCard creditCard, Integer limitAmount) {
		this.creditCard = creditCard;
		this.usedAmount = 0;
		this.limitAmount = limitAmount;
	}
}
