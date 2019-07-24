package com.sk.sample.park.payment.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.park.payment.domain.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentRestController implements PaymentService {
	@Autowired
	private PaymentService paymentService;
	
	@Override
	@PostMapping
	public boolean pay(@RequestParam("carnumber") String carnumber, @RequestParam("price") Integer price) {
		 return paymentService.pay(carnumber, price);
		 
	}

}
