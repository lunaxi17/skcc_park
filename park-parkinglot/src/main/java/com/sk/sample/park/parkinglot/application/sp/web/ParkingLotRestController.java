package com.sk.sample.park.parkinglot.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.park.parkinglot.domain.model.Parkinglot;
import com.sk.sample.park.parkinglot.domain.service.ParkingLotService;

@RestController
@RequestMapping("/v1/parkinglots")
public class ParkingLotRestController implements ParkingLotService{

	@Autowired
	private ParkingLotService parkingLotService;
	
	@Override
	@PostMapping("/parkin/{parkingLotId}")
	public void parkin(@PathVariable("parkingLotId") String parkingLotId) {
		// TODO Auto-generated method stub
		parkingLotService.parkin(parkingLotId);
	}

	@Override
	@PostMapping("/parkout/{parkingLotId}")
	public void parkout(@PathVariable("parkingLotId") String parkingLotId) {
		// TODO Auto-generated method stub
		parkingLotService.parkout(parkingLotId);
	}

	@Override
	@GetMapping("/search/parkinglotid")
	public Parkinglot findByParkingLotId(@RequestParam("parkingLotId") String parkinglotid) {
		return parkingLotService.findByParkingLotId(parkinglotid);
	}
	
	@Override
	@GetMapping("/{id}")
	public Parkinglot findById(@PathVariable("id") Long id) {
		return parkingLotService.findById(id);
	}
	
	

}
