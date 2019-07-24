package com.sk.sample.park.account.domain.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CreditCard implements com.sk.sample.park.account.domain.ValueObject {
	private String cardNumber;
	private String validThru;
	
	public CreditCard(String cardNumber, String validThru) {
		this.cardNumber = cardNumber;
		this.validThru = validThru;
	}
}
