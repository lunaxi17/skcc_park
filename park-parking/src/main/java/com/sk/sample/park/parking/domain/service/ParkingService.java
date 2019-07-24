package com.sk.sample.park.parking.domain.service;

public interface ParkingService {
	void parkIn(String parkingLotId, String carNumber);
	void parkOut(String parkingLotId, String carNumber);
}
