package com.sk.sample.park.parking.application.proxy.feign.dto.payment;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Payment {
	private CreditCard creditCard;
	private Integer purchasedAmount;
	private Boolean successed;
	private Date purchasedDate;
	
	public Payment(CreditCard creditCard, Integer purchasedAmount) {
		this.creditCard = creditCard;
		this.purchasedAmount = purchasedAmount;
		this.successed = false;
		this.purchasedDate = new Date();
	}
}
