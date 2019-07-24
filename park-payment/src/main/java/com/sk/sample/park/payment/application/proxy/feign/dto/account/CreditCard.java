package com.sk.sample.park.payment.application.proxy.feign.dto.account;

import javax.persistence.Embeddable;

import com.sk.sample.park.payment.domain.ValueObject;

import lombok.Data;

@Data
@Embeddable
public class CreditCard implements ValueObject {
	private String cardNumber;
	private String validThru;
	
	public CreditCard(String cardNumber, String validThru) {
		this.cardNumber = cardNumber;
		this.validThru = validThru;
	}
}