package com.sk.sample.park.parking.application.proxy.feign.dto.payment;

import com.sk.sample.park.parking.application.proxy.feign.dto.parkinglot.Parkinglot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CreditCard {
	private String cardNumber;
	private String validThru;
	
	public CreditCard(String cardNumber, String validThru) {
		this.cardNumber = cardNumber;
		this.validThru = validThru;
	}
}
