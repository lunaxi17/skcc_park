package com.sk.sample.park.parking.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.park.parking.domain.service.ParkingService;

@RestController
@RequestMapping("/v1/parkingLot")
public class ParkingRestController implements ParkingService{

	@Autowired
	private ParkingService parkingLotService;
	
	@Override
	@PutMapping("/{parkingLotId}/{carNumber}/parkIn")
	public void parkIn(@PathVariable("parkingLotId") String parkingLotId, @PathVariable("carNumber") String carNumber) {
		// TODO Auto-generated method stub
		parkingLotService.parkIn(parkingLotId, carNumber);
	}

	@Override
	@PutMapping("/{parkingLotId}/{carNumber}/parkOut")
	public void parkOut(@PathVariable("parkingLotId") String parkingLotId, @PathVariable("carNumber") String carNumber) {
		// TODO Auto-generated method stub
		parkingLotService.parkOut(parkingLotId, carNumber);
	}

}
