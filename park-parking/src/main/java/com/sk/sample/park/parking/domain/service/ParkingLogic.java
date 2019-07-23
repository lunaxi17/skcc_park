package com.sk.sample.park.parking.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.park.parking.domain.repository.ParkingRepository;

@Service("parkingLotLogic")
public class ParkingLogic implements ParkingService {

	@Autowired
	private ParkingRepository ParkingRepository;
	
	@Override
	public void parkIn(String parkingLotId, String carNumber) {
		// TODO Auto-generated method stub
//		Parking parkingLot = ParkingLotRepository.findByParkingLotId(parkingLotId);
//		parkingLot.setParkingCount(parkingLot.getParkingCount()+1);
//		ParkingLotRepository.save(parkingLot);
		
		
	}

	@Override
	public void parkOut(String parkingLotId, String carNumber) {
		// TODO Auto-generated method stub
//		Parking parkingLot = ParkingLotRepository.findByParkingLotId(parkingLotId);
//		parkingLot.setParkingCount(parkingLot.getParkingCount()-1);
//		ParkingLotRepository.save(parkingLot);
	}
	
}
