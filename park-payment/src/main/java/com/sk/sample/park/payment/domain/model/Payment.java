package com.sk.sample.park.payment.domain.model;

import java.util.Date;

import javax.persistence.Entity;

import com.sk.sample.park.payment.domain.AbstractEntity;
import com.sk.sample.park.payment.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Payment extends AbstractEntity implements AggregateRoot {
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
