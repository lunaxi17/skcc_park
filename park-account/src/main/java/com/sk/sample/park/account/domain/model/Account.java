package com.sk.sample.park.account.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.park.account.domain.AbstractEntity;
import com.sk.sample.park.account.domain.Address;
import com.sk.sample.park.account.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Account extends AbstractEntity implements AggregateRoot {
	private String email;
	private String name;
	private String carNumber;
	
	private CreditCard creditCard;
	
	@Enumerated(EnumType.ORDINAL)
	private MemberType memberType;
	
		
//	@Enumerated(EnumType.STRING)
//	private MembershipLevelType membershipLevelType;
	
	private Address address;
	
	public Account(String email, String name, MemberType memberType, String carNumber) {
		this(email, name, memberType, carNumber, null);
	}

	public Account(String email, String name, MemberType memberType, String carNumber, CreditCard creditCard) {
		this.email = email;
		this.name = name;
		this.memberType = memberType;
		this.carNumber = carNumber;
		this.creditCard = creditCard;
	}
}

