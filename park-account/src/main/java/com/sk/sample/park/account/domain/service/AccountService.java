package com.sk.sample.park.account.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.park.account.domain.model.Account;

public interface AccountService {
	Account findById(Long id);
	Account findByCarNumber(String carNumber);
	List<Account> findAll();
	Page<Account> findAll(Pageable pageable);
	
	List<Account> findByNameLike(String name);
	Account findByEmail(String email);
	
	Account register(Account account);
	Account update(Long id, Account account);

	void delete(Long id);
}
