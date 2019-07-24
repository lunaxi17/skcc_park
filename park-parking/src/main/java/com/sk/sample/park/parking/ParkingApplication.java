package com.sk.sample.park.parking;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.sk.sample.park.parking.domain.repository.ParkingRepository;
import com.sk.sample.park.parking.domain.service.ParkingService;

@SpringBootApplication
@EnableFeignClients
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner createSampleData(ParkingRepository parkingRepository, @Qualifier("parkingLogic") ParkingService parkingService) {	
		return (args) -> {
		};
	}

}
