package com.sk.sample.park.payment.application.proxy.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sk.sample.park.payment.application.proxy.feign.dto.account.Account;

@Service
public class AccountProxy {
	@Autowired
	private AccountClient accountClient;
	
	public Account findAccount(String carnumber) {
		return accountClient.findAccount(carnumber).getContent();
	}


	@FeignClient(name="accounts", url="http://localhost:11001", configuration=FeignClientConfiguration.class)
	interface AccountClient {
		@GetMapping("/v1/accounts/{carnumber}")
		Resource<Account> findAccount(@PathVariable("carnumber") String carnumber);
		
	}
}
