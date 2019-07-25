package com.sk.sample.park.parking.application.proxy.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.sample.park.parking.application.proxy.feign.dto.parkinglot.Parkinglot;

@Service
public class ParkinglotProxy {

	@Autowired
	private ParkinglotClient parkinglotClient;
	
	public Parkinglot findParkinglot(Long id) {
		return parkinglotClient.findParkinglot(id).getContent();
	}
	
	public void parkIn(String parkingLotId) {
		parkinglotClient.parkin(parkingLotId);
	}
	
	public void parkOut(String parkingLotId) {
		parkinglotClient.parkout(parkingLotId);
	}
	
	public Parkinglot findParkinglot(String parkinglotid) {
		return parkinglotClient.findParkinglot(parkinglotid).getContent();
	}
	
	@FeignClient(name="parkinglots", url="http://http://15.164.92.99:11002", configuration=FeignClientConfiguration.class)
	interface ParkinglotClient {
		@GetMapping("parkinglots/search/findByParkingLotId")
		Resource<Parkinglot> findParkinglot(@RequestParam("parkingLotId") String parkinglotid);
		
		@GetMapping("parkinglots/{id}")
		Resource<Parkinglot> findParkinglot(@PathVariable("id") Long id);
		
		@PostMapping("v1/parkinglots/parkin/{parkinglotid}")		
		void parkin(@PathVariable("parkinglotid") String parkingLotId);
		
		@PostMapping("v1/parkinglots/parkout/{parkinglotid}")		
		void parkout(@PathVariable("parkinglotid") String parkingLotId);
	}
}
