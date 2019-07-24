package com.sk.sample.park.parking.application.proxy.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PaymentProxy {
	
	@Autowired
	private PaymentClient paymentClient;
	
	public void requestPayment(String carnumber, String price) {
		paymentClient.requestPayments(carnumber, price);
	}
	
	@FeignClient(name="payments", url="http://localhost:11005", configuration=FeignClientConfiguration.class)
	interface PaymentClient {
		@PostMapping("payments")
		void requestPayments(@RequestParam("carnumber") String carnumber, @RequestParam("price") String price);
	}

}
