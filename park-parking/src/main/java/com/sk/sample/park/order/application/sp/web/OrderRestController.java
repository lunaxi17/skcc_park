package com.sk.sample.park.order.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.park.order.domain.service.OrderService;

@RestController
@RequestMapping("/v1/orders")
public class OrderRestController implements OrderService {
	@Autowired
	private OrderService orderService;

	@Override
	@PutMapping("/{parkingLotId}/{carNumber}/parkIn")
	public void parkIn(@PathVariable("parkingLotId") String parkingLotId, @PathVariable("carNumber")String carNumber) {
		orderService.parkIn(parkingLotId, carNumber);
		
	}

	@Override
	@PutMapping("/{parkingLotId}/{carNumber}/parkOut")
	public void parkOut(@PathVariable("parkingLotId") String parkingLotId, @PathVariable("carNumber")String carNumber) {
		orderService.parkOut(parkingLotId, carNumber);
	}

//	@Override
//	@PutMapping("/{id}/purchased")
//	public void purchase(@PathVariable("id") Long id) {
//		orderService.purchase(id);
//	}
}
