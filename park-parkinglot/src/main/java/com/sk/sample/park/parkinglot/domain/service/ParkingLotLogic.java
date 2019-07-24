package com.sk.sample.park.parkinglot.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.park.parkinglot.domain.model.Parkinglot;
import com.sk.sample.park.parkinglot.domain.repository.ParkingLotRepository;

@Service("parkingLotLogic")
public class ParkingLotLogic implements ParkingLotService {

	@Autowired
	private ParkingLotRepository ParkingLotRepository;
	
	@Override
	public void parkin(String parkinglotid) {
		// TODO Auto-generated method stub
		Parkinglot parkingLot = ParkingLotRepository.findByParkingLotId(parkinglotid);
		parkingLot.setParkingCount(parkingLot.getParkingCount()+1);
		ParkingLotRepository.save(parkingLot);
	}

	@Override
	public void parkout(String parkinglotid) {
		// TODO Auto-generated method stub
		Parkinglot parkingLot = ParkingLotRepository.findByParkingLotId(parkinglotid);
		parkingLot.setParkingCount(parkingLot.getParkingCount()-1);
		ParkingLotRepository.save(parkingLot);
	}

	@Override
	@Transactional(readOnly=true)
	public Parkinglot findByParkingLotId(String parkinglotid) {
		// TODO Auto-generated method stub
		return ParkingLotRepository.findByParkingLotId(parkinglotid);
	}

	@Override
	@Transactional(readOnly=true)
	public Parkinglot findById(Long id) {
		return ParkingLotRepository.findOne(id);
	}
	
}
