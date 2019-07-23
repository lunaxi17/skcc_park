package com.sk.sample.park.parkingLot.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.park.parkingLot.domain.model.ParkingLot;
import com.sk.sample.park.parkingLot.domain.repository.ParkingLotRepository;

@Service("parkingLotLogic")
public class ParkingLotLogic implements ParkingLotService {

	@Autowired
	private ParkingLotRepository ParkingLotRepository;
	
	@Override
	public void parkIn(String parkingLotId) {
		// TODO Auto-generated method stub
		ParkingLot parkingLot = ParkingLotRepository.findByParkingLotId(parkingLotId);
		parkingLot.setParkingCount(parkingLot.getParkingCount()+1);
		ParkingLotRepository.save(parkingLot);
	}

	@Override
	public void parkOut(String parkingLotId) {
		// TODO Auto-generated method stub
		ParkingLot parkingLot = ParkingLotRepository.findByParkingLotId(parkingLotId);
		parkingLot.setParkingCount(parkingLot.getParkingCount()-1);
		ParkingLotRepository.save(parkingLot);
	}
	
}
