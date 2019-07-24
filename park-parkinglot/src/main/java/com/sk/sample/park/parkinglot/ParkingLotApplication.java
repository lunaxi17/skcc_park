package com.sk.sample.park.parkinglot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.park.parkinglot.domain.model.Parkinglot;
import com.sk.sample.park.parkinglot.domain.repository.ParkingLotRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class ParkingLotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(ParkingLotRepository parkingLotRepository) {	
		return (args) -> {
			insertParkingLots(parkingLotRepository);
		};
	}
	
	public void insertParkingLots(ParkingLotRepository parkingLotRepository) {
		
		Parkinglot parkingLot1 = new Parkinglot("1", "분당 주차장", "경기도 성남시 분당구 정자동", 500, 10);
		parkingLotRepository.save(parkingLot1);
		
		Parkinglot parkingLot2 = new Parkinglot("2", "강남 주차장", "서울특별시 강남구 서초동", 2000, 25);
		parkingLotRepository.save(parkingLot2);
		
		Parkinglot parkingLot3 = new Parkinglot("3", "종로 주차장", "서울특별시 종로구 관평동", 1500, 2);
		parkingLotRepository.save(parkingLot3);
	}
}
