package com.sk.sample.park.order.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.sample.park.order.application.proxy.feign.ParkinglotProxy;
import com.sk.sample.park.order.application.proxy.feign.dto.parkinglot.Parkinglot;
import com.sk.sample.park.order.domain.model.Parking;
import com.sk.sample.park.order.domain.repository.OrderRepository;

@Service("orderLogic")
public class OrderLogic implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private ParkinglotProxy parkinglotProxy;
	
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
		System.out.println("Parking Price >>>>> "+price);
		parking.setParkOutTm(String.valueOf(parkTime));
		orderRepository.save(parking);
		orderRepository.delete(parking.getId());
	}
	
	
	
//	@Autowired
//	private AccountProxy accountProxy;
//	
//	@Autowired
//	private ProductProxy productProxy;
//	
//	public void purchase(Long orderId) {
//		Order order = orderRepository.findOne(orderId);
//		
//		if(order == null) {
//			System.err.println("no purchase");
//			return;
//		}
//		
//		System.out.println("Purchase: " + order.toString());
//		
//		if(order.getPurchased() == true) {
//			System.err.println("already purchased");
//			return;
//		}
//		if(order.getCreditCard() == null) {
//			System.err.println("no credit card");
//			return;
//		}
//		
//		if(order.getShippingAddress() == null) {
//			System.err.println("no shippig address");
//			return;
//		}
//		
//		Account account = accountProxy.findAccount(order.getBuyerAccountId());
//		System.out.println("Buyer: " + account.toString());
//			
//		Product product = productProxy.findProduct(order.getProductId());
//		System.out.println("Product: " + product.toString());
//			
//		order.setTotalPrice(order.getProductCount() * product.getPrice().getValue());
//		order.setPurchased(true);
//		System.out.println("Order: " + order.toString());
//			
//		orderRepository.save(order);
//	}
}
