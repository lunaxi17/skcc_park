package com.sk.sample.park.payment.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.park.payment.application.proxy.feign.AccountProxy;
import com.sk.sample.park.payment.domain.model.CreditCard;
import com.sk.sample.park.payment.domain.model.Payment;
import com.sk.sample.park.payment.domain.repository.PaymentRepository;

@Service
public class PaymentLogic implements PaymentService {
	
	@Autowired
	private PaymentRepository purchaseRepository;
	
	@Autowired
	private AccountProxy accountProxy;
	
	@Override
	@Transactional
	public boolean pay(String carnumber, Integer price) {
		
		// carnumber로 account의 cardnumber, validThru 가져오기
		System.out.println(carnumber + price);
		
		
		Payment payment = new Payment(CreditCard.builder().cardNumber("1234").validThru("0719").build(), price) ;

		payment.setPurchasedDate(new Date());		
		payment.setSuccessed(true);
		
		purchaseRepository.save(payment);
		
		return true;
		
		//Account account = accountProxy.findAccount(carnumber);
		
		
		/*
		Credit credit = creditRepository.findByCreditCardCardNumber(requestedCreditCard.getCardNumber());
		
		if(credit == null) {
			System.err.println("no credit");
			return payment;
		}
		
		if(!credit.getCreditCard().getValidThru().equals(requestedCreditCard.getValidThru())) {
			System.err.println("not matched validThru");
			return payment;
		}
		
		// Valid Thru 유효성 체크 
		
		if(credit.getUsedAmount() + amount > credit.getLimitAmount()) {
			System.err.println("한도 초과");
			return payment;
		}
		
		credit.setUsedAmount(credit.getUsedAmount() + amount);
		creditRepository.save(credit);
		*/
		

	}

}
