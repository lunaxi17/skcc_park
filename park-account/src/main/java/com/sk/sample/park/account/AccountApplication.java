package com.sk.sample.park.account;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;
import com.sk.sample.park.account.domain.model.Account;
import com.sk.sample.park.account.domain.model.MemberType;
import com.sk.sample.park.account.domain.model.CreditCard;
import com.sk.sample.park.account.domain.model.QAccount;
import com.sk.sample.park.account.domain.repository.AccountRepository;
import com.sk.sample.park.shared.domain.Address;

@SpringBootApplication
public class AccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(AccountRepository accountRepository) {	
		return (args) -> {
			insertAccounts(accountRepository);
			displayAccounts(accountRepository);
			
			executeExample1(accountRepository);
		};
	}
		
	public void insertAccounts(AccountRepository accountRepository) {
		
		Account account1 = new Account("king@sk.com", "아더왕", MemberType.BUYER, "111");
		account1.setCreditCard(new CreditCard("11111111", "111"));
		accountRepository.save(account1);
		
		
		Account account2 = new Account("kim@sk.com", "김정은", MemberType.BUYER, "222");
		//account2.setAddress(new Address(12345, "서울시 강남구"));
		account2.setCreditCard(new CreditCard("22222222", "222"));
		accountRepository.save(account2);
		
		Account account3 = new Account("moon@gmail.com", "문재인", MemberType.SELLER, "333");
		account3.setCreditCard(new CreditCard("33333333", "333"));
		accountRepository.save(account3);
		
		Account account4 = new Account("kill@sk.com", "아베이놈", MemberType.BUYER, "444");
		account4.setCreditCard(new CreditCard("44444444", "444"));
		accountRepository.save(account4);  
	}
	
	public void displayAccounts(AccountRepository accountRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Account> accountList = accountRepository.findAll();
		for(Account account : accountList) {
			System.out.println(account.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
	public void executeExample1(AccountRepository accountRepository) {
/*		Account account = accountRepository.findByEmail("hong@sk.com");
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		accountRepository.save(account);
		
		displayAccounts(accountRepository);  */
	}

	
	public void executeExample2(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findByAddressZipCode(12345);
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample3(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findByAddressHomeAddressLike("성남");
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample4(AccountRepository accountRepository) {
		QAccount.account.name.like("강%");
		Account account = accountRepository.findOne(QAccount.account.email.eq("hong@sk.com"));
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		accountRepository.save(account);
		
		displayAccounts(accountRepository);
	}
	
	public void executeExample5(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findAll(QAccount.account.address.zipCode.eq(12345));
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample6(AccountRepository accountRepository) {
		List<Account> account = accountRepository.findAll(QAccount.account.address.homeAddress.like("성남"));
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample7(AccountRepository accountRepository) {
/*		Predicate predicate = QAccount.account.memberType.eq(MemberType.BUYER).and(
				              QAccount.account.membershipLevelType.eq(CreditCard.VIP));
		List<Account> account = accountRepository.findAll(predicate);
		System.out.println("Result: " + account.toString());  */
	}

	
	/*
	@Bean
	public CommandLineRunner execSampleCode2(@Qualifier("accountLogic") AccountService accountService) {
		return (args) -> {
			Account account = new Account("iu@sk.com", "아이유", MemberType.BUYER, MembershipLevelType.VIP);
			accountService.register(account);
			
			Account result = accountService.findByEmail("iu@sk.com");
			System.out.println("Component API Result - " + result);
			
			result.setAddress(new Address(11111, "서울시 영등포구"));
			accountService.update(result.getId(), result);
			
			Account result2 = accountService.findByEmail("iu@sk.com");
			System.out.println("Component API Result2 - " + result2);
		};
	}
	*/
}
