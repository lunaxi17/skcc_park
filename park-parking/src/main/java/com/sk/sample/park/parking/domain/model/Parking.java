package com.sk.sample.park.parking.domain.model;

import java.util.Date;

import javax.persistence.Entity;

import com.sk.sample.park.shared.base.AbstractEntity;
import com.sk.sample.park.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Parking extends AbstractEntity implements AggregateRoot {
	private String parkingId;
	private String userId;
	private int parkInTm;
	private int parkOutTm;
	
	public Parking(String parkingId, String userId, int parkInTm) {
		this.parkingId = parkingId;
		this.userId = userId;
		this.parkInTm = parkInTm;
	}
	
}

