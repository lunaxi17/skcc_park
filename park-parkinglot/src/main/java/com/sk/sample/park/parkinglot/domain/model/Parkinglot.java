package com.sk.sample.park.parkinglot.domain.model;

import javax.persistence.Entity;

import com.sk.sample.park.shared.base.AbstractEntity;
import com.sk.sample.park.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Parkinglot extends AbstractEntity implements AggregateRoot {
	private String parkingLotId;	//주차장 일련번호
	private String name;			//주차장 명
	private String address;			//주차장 위치
	private int pricePerMin;		//분당 주차 요금
	private int parkingAmount;		//주차장 주차 면 수
	private int parkingCount;		//주차장 주차 수
	
	//constructor
	public Parkinglot(String parkingLotId, String name, String address, int pricePerMin, int parkingAmount) {
		this.parkingLotId = parkingLotId;
		this.name = name;
		this.address = address;
		this.pricePerMin = pricePerMin;
		this.parkingAmount = parkingAmount;
		this.parkingCount = 0;
	}
}

