package com.sk.sample.park.parking.application.proxy.fein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sk.sample.park.parking.application.proxy.fein.dto.parkingLot.ParkingLot;

@Service
public class ParkingLotProxy {
	
	@Autowired
	private ParkingLotClient parkingLotClient;
	
	public ParkingLot findParkingLot(String parkingLotId) {
		return parkingLotClient.findParkingLot(parkingLotId).getContent();
	}
	
	
	@FeignClient(name="parkingLot", url="http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface ParkingLotClient {
		@GetMapping("parkingLot/{parkingLotId]")
		Resource<ParkingLot> findParkingLot(@PathVariable("parkingLotId") String parkingLotId);
		
	}
}
