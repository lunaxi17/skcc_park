package com.sk.sample.park.order.domain.service;

public interface OrderService {
	void parkIn(String parkingLotId, String carNumber);
	void parkOut(String parkingLotId, String carNumber);
}
