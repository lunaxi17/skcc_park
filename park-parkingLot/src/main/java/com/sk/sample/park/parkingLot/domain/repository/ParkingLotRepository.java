package com.sk.sample.park.parkingLot.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.park.parkingLot.domain.model.ParkingLot;

@RepositoryRestResource
public interface ParkingLotRepository extends PagingAndSortingRepository<ParkingLot, Long>,
                                           QueryDslPredicateExecutor<ParkingLot> {
	List<ParkingLot> findAll(Predicate predicate); 
	
	ParkingLot findByName(@Param("name") String name);
	ParkingLot findByParkingLotId(@Param("parkingLotId") String parkingLotId);
//	List<ParkingLot> findByProductDescriptionSizeType(@Param("sizeType") SizeType sizeType);
//	List<ParkingLot> findByProductDescriptionColorType(@Param("colorType") ColorType colorType);
//	List<ParkingLot> findByPriceValueGreaterThanEqual(@Param("value") Integer value);
//	List<ParkingLot> findByPriceValueLessThanEqual(@Param("value") Integer value);
//	List<ParkingLot> findByPriceValueGreaterThanAndPriceValueLessThan(@Param("value1") Integer value1, @Param("value2") Integer value2);
}
