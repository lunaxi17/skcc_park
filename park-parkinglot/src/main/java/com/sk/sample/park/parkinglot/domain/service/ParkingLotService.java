package com.sk.sample.park.parkinglot.domain.service;

import com.sk.sample.park.parkinglot.domain.model.Parkinglot;

public interface ParkingLotService {
	void parkin(String parkinglotid);
	void parkout(String parkinglotid);
	
	Parkinglot findByParkingLotId(String parkinglotid);
	Parkinglot findById(Long id);
}
