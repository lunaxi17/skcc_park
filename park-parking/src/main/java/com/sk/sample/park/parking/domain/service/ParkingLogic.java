package com.sk.sample.park.parking.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.park.parking.application.proxy.feign.ParkinglotProxy;
import com.sk.sample.park.parking.application.proxy.feign.PaymentProxy;
import com.sk.sample.park.parking.application.proxy.feign.dto.parkinglot.Parkinglot;
import com.sk.sample.park.parking.domain.model.Parking;
import com.sk.sample.park.parking.domain.repository.ParkingRepository;

@Service("parkingLogic")
public class ParkingLogic implements ParkingService {
	@Autowired
	private ParkingRepository orderRepository;
	
	
	@Autowired
	private ParkinglotProxy parkinglotProxy;
	
	@Autowired
	private PaymentProxy paymentProxy;
	
	@Override
	public void parkIn(String parkingLotId, String carNumber) {
		
//		Parkinglot parkingLot = parkinglotProxy.findParkinglot(parkingLotId);
		parkinglotProxy.parkIn(parkingLotId);
		
		long parkTime = System.currentTimeMillis() / (1000 * 60);
		Parking parking = new Parking(parkingLotId, carNumber, String.valueOf(parkTime));
		
		orderRepository.save(parking);
		
	}

	@Override
	public void parkOut(String parkingLotId, String carNumber) {
		Parkinglot parkingLot = parkinglotProxy.findParkinglot(parkingLotId);
		parkinglotProxy.parkOut(parkingLotId);
		
		long parkTime = System.currentTimeMillis() / (1000 * 60);
		
		Parking parking = orderRepository.findByCarNumber(carNumber);
		System.out.println("time >>>> " + parkTime);
		long parkingTime = parkTime - Integer.parseInt(parking.getParkInTm());
		long price = parkingTime * parkingLot.getPricePerMin();
		
		paymentProxy.requestPayment(carNumber, String.valueOf(price));
		
		System.out.println("Parking Price >>>>> "+price);
		parking.setParkOutTm(String.valueOf(parkTime));
		orderRepository.save(parking);
		orderRepository.delete(parking.getId());
	}
}
