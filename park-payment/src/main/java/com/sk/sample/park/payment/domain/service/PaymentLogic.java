package com.sk.sample.park.payment.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.park.payment.application.proxy.feign.AccountProxy;
import com.sk.sample.park.payment.application.proxy.feign.dto.account.Account;
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
		Account account = accountProxy.findAccount(carnumber);
		
		String cardNumber = account.getCreditCard().getCardNumber();		
		
		Payment payment = new Payment(CreditCard.builder().cardNumber(cardNumber).validThru("0719").build(), price) ;

		payment.setPurchasedDate(new Date());		
		payment.setSuccessed(true);
		
		purchaseRepository.save(payment);
		
		return true;		

	}

}
