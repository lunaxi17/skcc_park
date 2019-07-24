package com.sk.sample.park.parking.domain.model;

import javax.persistence.Entity;

import com.sk.sample.park.parking.domain.AbstractEntity;
import com.sk.sample.park.parking.domain.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Parking extends AbstractEntity implements AggregateRoot {
	private String parkingLotId;
	private String carNumber;
	private String parkInTm;
	private String parkOutTm;
	
	public Parking(String parkingLotId, String carNumber, String parkInTm) {
		this.parkingLotId = parkingLotId;
		this.carNumber = carNumber;
		this.parkInTm = parkInTm;
	}
}
