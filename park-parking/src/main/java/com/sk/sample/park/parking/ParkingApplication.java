package com.sk.sample.park.parking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.sample.park.parking.domain.repository.ParkingRepository;

@SpringBootApplication
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(ParkingRepository parkingLotRepository) {	
		return (args) -> {
//			insertParkingLots(parkingLotRepository);
		};
	}
	
//	public void insertParkingLots(ParkingRepository parkingLotRepository) {
//		
//		Parking parkingLot1 = new Parking("1", "분당 주차장", "경기도 성남시 분당구 정자동", 500, 10);
//		parkingLotRepository.save(parkingLot1);
//		
//		Parking parkingLot2 = new Parking("2", "강남 주차장", "서울특별시 강남구 서초동", 2000, 25);
//		parkingLotRepository.save(parkingLot2);
//		
//		Parking parkingLot3 = new Parking("3", "종로 주차장", "서울특별시 종로구 관평동", 1500, 2);
//		parkingLotRepository.save(parkingLot3);
//	}
}
