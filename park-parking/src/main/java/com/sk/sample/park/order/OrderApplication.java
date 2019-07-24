package com.sk.sample.park.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.sk.sample.park.order.domain.model.CreditCard;
import com.sk.sample.park.order.domain.model.Order;
import com.sk.sample.park.order.domain.repository.OrderRepository;
import com.sk.sample.park.order.domain.service.OrderService;
import com.sk.sample.park.shared.domain.Address;

@SpringBootApplication
@EnableFeignClients
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createSampleData(OrderRepository orderRepository, @Qualifier("orderLogic") OrderService orderService) {	
		return (args) -> {
			
		};
	}

}