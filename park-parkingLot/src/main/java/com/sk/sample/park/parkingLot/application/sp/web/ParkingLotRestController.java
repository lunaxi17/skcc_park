package com.sk.sample.park.parkingLot.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.park.parkingLot.domain.service.ParkingLotService;

@RestController
@RequestMapping("/v1/parkingLot")
public class ParkingLotRestController implements ParkingLotService{

	@Autowired
	private ParkingLotService parkingLotService;
	
	@Override
	@PutMapping("/{parkingLotId}/parkIn")
	public void parkIn(@PathVariable("parkingLotId") String parkingLotId) {
		// TODO Auto-generated method stub
		parkingLotService.parkIn(parkingLotId);
	}

	@Override
	@PutMapping("/{parkingLotId}/parkOut")
	public void parkOut(@PathVariable("parkingLotId") String parkingLotId) {
		// TODO Auto-generated method stub
		parkingLotService.parkOut(parkingLotId);
	}

}
